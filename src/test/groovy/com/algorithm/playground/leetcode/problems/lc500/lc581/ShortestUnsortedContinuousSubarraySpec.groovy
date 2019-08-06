package com.algorithm.playground.leetcode.problems.lc500.lc581

import com.algorithm.playground.leetcode.problems.lc500.lc581.ShortestUnsortedContinuousSubarray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
class ShortestUnsortedContinuousSubarraySpec extends Specification {

	@Unroll
	def "findUnsortedSubarray"() {

		expect:

			new S().findUnsortedSubarray(nums as int[]) == out

		where:

			nums                    || out
			[2, 6, 4, 8, 10, 9, 15] || 5
			[1, 3, 2, 2, 2]         || 4
			[1]                     || 0
			[1, 1]                  || 0
			[1, 2, 4, 5, 3]         || 3

	}

}