package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1005

import com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1005.MaximizeSumOfArrayAfterKNegations.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximizeSumOfArrayAfterKNegationsSpec extends Specification {

	@Unroll
	def "largestSumAfterKNegations"() {

		expect:

			new S().largestSumAfterKNegations(A as int[], k) == out

		where:

			A                       | k || out
			[4, 2, 3]               | 1 || 5
			[3, -1, 0, 2]           | 3 || 6
			[2, -3, -1, 5, -4]      | 2 || 13
			[-2, 5, 0, 2, -2]       | 3 || 11
			[-8, 3, -5, -3, -5, -2] | 6 || 22


	}

}
