package com.algorithm.playground.leetcode.problems.lc200.lc279

import com.algorithm.playground.leetcode.problems.lc200.lc279.PerfectSquares.Solution as S
import com.algorithm.playground.leetcode.problems.lc200.lc279.PerfectSquares.SolutionDP as SDP
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 *
 *
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class PerfectSquaresSpec extends Specification {

	@Unroll
	def "numSquares"() {

		expect:

			new S().numSquares(n) == out

		where:

			n  || out
			12 || 3
			13 || 2

	}

	@Unroll
	def "numSquares_dp"() {

		expect:

			new SDP().numSquares(n) == out

		where:

			n  || out
			12 || 3
			13 || 2

	}

}