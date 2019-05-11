package com.algorithm.playground.google.kickstart._2019.a.task1

import spock.lang.Specification
import spock.lang.Unroll

class TrainingSpec extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(players as int[], n) == out

		where:

			players            | n || out
			[3, 1, 9, 100]     | 3 || 14
			[5, 5, 1, 2, 3, 4] | 2 || 0
			[7, 7, 1, 7, 7]    | 5 || 6

	}

}
