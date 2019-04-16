package com.algorithm.playground.google.codejam._2018.qualification.task2

import spock.lang.Specification
import spock.lang.Unroll

class TroubleSort extends Specification {

	@Unroll
	def "solve"() {

		expect:

			Solution.solve(input as int[]) == out

		where:

			input           || out
			[5, 6, 8, 4, 3] || -1
			[8, 9, 7]       || 1

	}

}
