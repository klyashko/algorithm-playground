package com.algorithm.playground.google.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.runAsync;

public class LocalInteractiveTestRunner {

	private static final String COMMAND = "python %stesting_tool.py %s";
	@SuppressWarnings("FieldCanBeLocal")
	public static long TIMEOUT = 30 * 1000;

	public static void runWithArgs(Runnable runner, String... args) {
		run(runner, "", args);
	}

	public static void run(Runnable runner, String folder, String... args) {
		String argsLine = String.join(" ", args);
		String command = String.format(COMMAND, folder, argsLine);

		PrintStream ps = System.out;
		InputStream is = System.in;

		try {
			/** start process */
			Process process = new ProcessBuilder().command(command.split(" "))
					.redirectErrorStream(true)
					.start();

			/** set up io */

			/**Set new system in stream with redirect to default system out*/
			System.setIn(new RedirectInputStream(process.getInputStream(), ps));
			TupleOutputStream os = new TupleOutputStream(ps, process.getOutputStream());
			/**Set new system out stream with duplication writs to process output and default system out*/
			System.setOut(new PrintStream(os, true));

			/** run the program */
			runAsync(runner).get(TIMEOUT, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			System.setIn(is);
			System.setOut(ps);
		}
	}

	private static class RedirectInputStream extends InputStream {

		private static final byte[] MARKER = "IN:  ".getBytes();

		private final InputStream source;
		private final PrintStream redirect;

		private RedirectInputStream(InputStream source, PrintStream redirect) {
			this.source = source;
			this.redirect = redirect;
		}

		@Override
		public int read() throws IOException {
			int i = source.read();
			if (i != -1) {
				redirect.write(i);
			}
			return i;
		}

		@Override
		public synchronized int read(byte[] b, int off, int len) throws IOException {
			int i = source.read(b, off, len);
			if (i != -1) {
				redirect.write(MARKER);
				redirect.write(b, off, i);
			}
			return i;
		}

		@Override
		public int read(byte[] b) throws IOException {
			return read(b, 0, b.length);
		}

		@Override
		public long skip(long n) throws IOException {
			return source.skip(n);
		}

		@Override
		public int available() throws IOException {
			return source.available();
		}

		@Override
		public void close() { }

		@Override
		public synchronized void mark(int readlimit) {
			source.mark(readlimit);
		}

		@Override
		public synchronized void reset() throws IOException {
			source.reset();
		}

		@Override
		public boolean markSupported() {
			return source.markSupported();
		}
	}

	private static class TupleOutputStream extends OutputStream {

		private static final byte[] SEP = System.getProperty("line.separator").getBytes();
		private static final byte[] MARKER = "OUT: ".getBytes();
		private static final byte[] DEBUG_MARKER = "DEBUG: ".getBytes();

		private final OutputStream logger;
		private final OutputStream process;

		private boolean newLine = true;
		private boolean ignore = false;

		private TupleOutputStream(OutputStream logger, OutputStream process) {
			this.logger = logger;
			this.process = process;
		}

		private static boolean equals(byte[] b, int off, int len, byte[] b2) {
			if (len < b2.length) {
				return false;
			}
			for (int i = b2.length - 1; i >= 0; i--) {
				if (b2[i] != b[off + i]) {
					return false;
				}
			}
			return true;
		}

		@Override
		public void write(int b) throws IOException {
			logger.write(b);
			process.write(b);
		}

		@Override
		public void write(byte[] b) throws IOException {
			write(b, 0, b.length);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			if (newLine) {
				ignore = equals(b, off, len, DEBUG_MARKER);
				if (!ignore) {
					logger.write(MARKER);
				}
			}
			newLine = equals(b, off, len, SEP);
			logger.write(b, off, len);
			if (!ignore) {
				process.write(b, off, len);
			}
		}

		@Override
		public void flush() throws IOException {
			logger.flush();
			process.flush();
		}

		@Override
		public void close() throws IOException {
			process.close();
		}

	}

}