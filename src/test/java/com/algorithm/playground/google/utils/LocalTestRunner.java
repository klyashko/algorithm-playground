package com.algorithm.playground.google.utils;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LocalTestRunner {

	public static List<String> exec(Runnable runner, List<String> inputs) {
		String data = inputs.size() + "\n" + String.join("\n", inputs);

		PrintStream out = System.out;
		InputStream is = System.in;

		try {
			/** Set up io */
			TestResultsCollectorOutputStream os = new TestResultsCollectorOutputStream(System.out);
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			System.setOut(new PrintStream(os, true));

			/** run the solution */
			runner.run();

			return os.results();
		} finally {
			System.setOut(out);
			System.setIn(is);
		}
	}

	private static class TestResultsCollectorOutputStream extends OutputStream {

		private static final String PATTERN = "Case #";
		private static final String SEP = System.getProperty("line.separator");

		private final OutputStream out;
		private final ByteArrayOutputStream collector;

		private TestResultsCollectorOutputStream(OutputStream out) {
			this.out = out;
			this.collector = new ByteArrayOutputStream();
		}

		@Override
		public void write(int b) throws IOException {
			out.write(b);
			collector.write(b);
		}

		@Override
		public void write(byte[] b) throws IOException {
			write(b, 0, b.length);
		}

		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			out.write(b, off, len);
			collector.write(b, off, len);
		}

		@Override
		public void flush() throws IOException {
			out.flush();
		}

		private List<String> results() {
			String curr = new String(collector.toByteArray());
			return Stream.of(curr.split(SEP))
					.filter(line -> line.startsWith(PATTERN))
					.map(String::trim)
					.collect(toList());
		}

	}

}
