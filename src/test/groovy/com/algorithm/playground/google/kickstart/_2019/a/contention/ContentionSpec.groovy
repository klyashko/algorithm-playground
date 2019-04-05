package com.algorithm.playground.google.kickstart._2019.a.contention

import spock.lang.Specification
import spock.lang.Unroll

class ContentionSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(intervals as int[][]) == out

		where:

			intervals  || out
			[[1, 2],
			 [3, 4],
			 [2, 5]]   || 1
			[[10, 11],
			 [10, 10],
			 [11, 11]] || 0
			[[1, 8],
			 [4, 5],
			 [3, 6],
			 [2, 7]]    | 2
			[[5, 25],
			 [50, 80]]  | 21
			[[1, 4],
			 [2, 10]]   | 4

	}

	def "solve_tmp"() {

		given:

			def intervals = []
			300.times { intervals << [1, 1_000_000] }
			def out = Solution.solve(intervals as int[][])
			println(out)

	}

	def "main"() {

		given:

			def data = "3\n" +
					"5 3\n" +
					"1 2\n" +
					"3 4\n" +
					"2 5\n" +
					"30 3\n" +
					"10 11\n" +
					"10 10\n" +
					"11 11\n" +
					"10 4\n" +
					"1 8\n" +
					"4 5\n" +
					"3 6\n" +
					"2 7"

			def is = new ByteArrayInputStream(data.getBytes())
			System.in = is
			Solution.main()

	}

}