package com.algorithm.playground.leetcode.problems.lc700.lc793

import com.algorithm.playground.leetcode.problems.lc700.lc793.PreimageSizeOfFactorialZeroesFunction.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 * Input: K = 0
 * Output: 5
 * Explanation: 0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
 *
 * Example 2:
 * Input: K = 5
 * Output: 0
 * Explanation: There is no x such that x! ends in K = 5 zeroes.
 *
 * Note:
 *
 * K will be an integer in the range [0, 10^9].
 */
class PreimageSizeOfFactorialZeroesFunctionSpec extends Specification {

	@Unroll
	def "preimageSizeFZF"() {

		expect:

			new S().preimageSizeFZF(K) == out

		where:

			K  || out
			0  || 5
			5  || 0
			3  || 5
			25 || 5

	}

}
