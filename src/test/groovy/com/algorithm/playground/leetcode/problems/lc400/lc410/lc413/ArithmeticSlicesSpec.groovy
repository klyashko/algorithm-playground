package com.algorithm.playground.leetcode.problems.lc400.lc410.lc413


import spock.lang.Specification
import spock.lang.Unroll

class ArithmeticSlicesSpec extends Specification {

	@Unroll
	def "numberOfArithmeticSlices"() {

		expect:

			new ArithmeticSlices.Solution().numberOfArithmeticSlices(input as int[]) == output

		where:

			input               || output
			[1, 2, 3, 4]        || 3
			[1, 2, 3, 8, 9, 10] || 2
			[]                  || 0

	}

}
