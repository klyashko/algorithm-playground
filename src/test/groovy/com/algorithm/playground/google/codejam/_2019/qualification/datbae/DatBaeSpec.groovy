package com.algorithm.playground.google.codejam._2019.qualification.datbae

import spock.lang.Specification

import java.util.concurrent.CompletableFuture

class DatBaeSpec extends Specification {

	def "test"() {

		given:

			def p = Runtime.getRuntime().exec("python C:\\Users\\kipil\\Downloads\\testing_tool.py 0")
			BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()))

			String line
			while ((line = is.readLine()) != null) {
				System.out.println(line)
			}


	}

	def "main"() {

		given:

			boolean[] nodes = [false, true, true, false, true]
			def data = "1\n" +
					"5 2 5"
			System.in = new ByteArrayInputStream(data.bytes)
			def out = new ByteArrayOutputStream()
			def ps = new PrintStream(out)

			System.out = ps

			CompletableFuture.runAsync(new Validator(nodes, out))

			Solution.main()

	}

	class Validator implements Runnable {

		private boolean[] nodes
		private ByteArrayOutputStream os

		private Validator(boolean[] nodes, ByteArrayOutputStream os) {
			this.nodes = nodes
			this.os = os
		}

		@Override
		void run() {
			while (true) {
				String s = new String(os.toByteArray())
				if (!s.isEmpty()) {
					println(s)
					break
				}
			}

		}

	}

}
