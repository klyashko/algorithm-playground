package com.algorithm.playground.leetcode.problems.lc400.lc494

import com.algorithm.playground.leetcode.problems.lc400.lc494.TargetSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
class TargetSumSpec extends Specification {

	@Unroll
	def "findTargetSumWays"() {

		expect:

			new S().findTargetSumWays(nums as int[], s) == out

		where:

			nums              | s             || out
			[1, 1, 1, 1, 1]   | 3             || 5
			[1, 2, 7, 9, 981] | 1_000_000_000 || 0

	}

}