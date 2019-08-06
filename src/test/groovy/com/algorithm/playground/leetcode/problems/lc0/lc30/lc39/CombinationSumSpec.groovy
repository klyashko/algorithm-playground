package com.algorithm.playground.leetcode.problems.lc0.lc30.lc39

import com.algorithm.playground.leetcode.problems.lc0.lc30.lc39.CombinationSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
class CombinationSumSpec extends Specification {

	@Unroll
	def "combinationSum"() {

		expect:

			new S().combinationSum(candidates as int[], target).toSet() == out.toSet()

		where:

			candidates   | target || out
			[2, 3, 6, 7] | 7      || [[7],
									  [2, 2, 3]]
			[2, 3, 5]    | 8      || [[2, 2, 2, 2],
									  [2, 3, 3],
									  [3, 5]]

	}

}