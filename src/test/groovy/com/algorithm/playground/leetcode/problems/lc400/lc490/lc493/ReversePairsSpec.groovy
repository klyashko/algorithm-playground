package com.algorithm.playground.leetcode.problems.lc400.lc490.lc493


import spock.lang.Specification
import spock.lang.Unroll

class ReversePairsSpec extends Specification {

	@Unroll
	def "reversePairs"() {

		expect:

			new ReversePairs.Solution().reversePairs(nums as int[]) == output

		where:

			nums                                                                        || output
			[1, 3, 2, 3, 1]                                                             || 2
			[2, 4, 3, 5, 1]                                                             || 3
			[-5, -5]                                                                    || 1
			[2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647]    || 0
			[2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647] || 9
			[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]                                          || 0

	}

}
