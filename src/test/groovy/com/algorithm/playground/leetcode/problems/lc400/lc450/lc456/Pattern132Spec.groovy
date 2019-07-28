package com.algorithm.playground.leetcode.problems.lc400.lc450.lc456

import com.algorithm.playground.leetcode.problems.lc400.lc450.lc456.Pattern132.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 * Input: [1, 2, 3, 4]
 *
 * Output: False
 *
 * Explanation: There is no 132 pattern in the sequence.
 *
 *
 * Example 2:
 * Input: [3, 1, 4, 2]
 *
 * Output: True
 *
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 *
 * Example 3:
 * Input: [-1, 3, 2, 0]
 *
 * Output: True
 *
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
class Pattern132Spec extends Specification {

	@Unroll
	def "find132pattern"() {

		expect:

			new S().find132pattern(nums as int[]) == out

		where:

			nums              || out
			[1, 2, 3, 4]      || false
			[3, 1, 4, 2]      || true
			[-1, 3, 2, 0]     || true
			[1, 0, 1, -4, -3] || false
			[]                || false

	}

}