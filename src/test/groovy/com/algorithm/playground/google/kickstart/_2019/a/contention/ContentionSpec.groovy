package com.algorithm.playground.google.kickstart._2019.a.contention

import spock.lang.Specification
import spock.lang.Unroll

class ContentionSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(intervals as int[][], n) == out

		where:

			intervals  | n  || out
			[[1, 2],
			 [3, 4],
			 [2, 5]]   | 5  || 1
			[[10, 11],
			 [10, 10],
			 [11, 11]] | 30 || 0
			[[1, 8],
			 [4, 5],
			 [3, 6],
			 [2, 7]]   | 10  | 2

	}

	@Unroll
	def "solve_tmp"() {

		given:

			def intervals = []
			300.times { intervals << [1, 1_000_000] }
			def out = Solution.solve(intervals as int[][], 1_000_000)
			println(out)

		expect:

			true
	}

}
