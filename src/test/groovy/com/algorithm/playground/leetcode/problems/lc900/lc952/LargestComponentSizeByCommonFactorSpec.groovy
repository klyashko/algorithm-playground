package com.algorithm.playground.leetcode.problems.lc900.lc952

import com.algorithm.playground.leetcode.problems.lc900.lc952.LargestComponentSizeByCommonFactor.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LargestComponentSizeByCommonFactorSpec extends Specification {

	@Unroll
	def "largestComponentSize"() {

		expect:

			new S().largestComponentSize(A as int[]) == out

		where:

			A                           || out
			[4, 6, 15, 35]              || 4
			[20, 50, 9, 63]             || 2
			[2, 3, 6, 7, 4, 12, 21, 39] || 8
			[1, 2, 3, 4, 5, 6, 7, 8, 9] || 6

	}

}
