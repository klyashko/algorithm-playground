package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1124

import com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1124.LongestWellPerformingInterval.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 */
class LongestWellPerformingIntervalSpec extends Specification {

	@Unroll
	def "longestWPI"() {

		expect:

			new S().longestWPI(hours as int[]) == out

		where:

			hours                          || out
			[9, 9, 6, 0, 6, 6, 9]          || 3
			[6, 6, 6, 9, 9, 9, 0, 6, 6, 7] || 5

	}

}