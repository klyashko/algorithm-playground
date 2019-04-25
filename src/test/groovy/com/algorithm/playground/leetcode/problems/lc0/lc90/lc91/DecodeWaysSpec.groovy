package com.algorithm.playground.leetcode.problems.lc0.lc90.lc91

import com.algorithm.playground.leetcode.problems.lc0.lc90.lc91.DecodeWays.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 */
class DecodeWaysSpec extends Specification {

	@Unroll
	def "numDecodings"() {

		expect:

			new S().numDecodings(s) == out

		where:

			s                                                                                                      || out
			"12"                                                                                                   || 2
			"21"                                                                                                   || 2
			"226"                                                                                                  || 3
			"116"                                                                                                  || 3
			"0"                                                                                                    || 0
			"01"                                                                                                   || 0
			"101"                                                                                                  || 1
			"10"                                                                                                   || 1
			"110"                                                                                                  || 1
			"301"                                                                                                  || 0
			"9"                                                                                                    || 1
			"99"                                                                                                   || 1
			"96603"                                                                                                || 0
			"4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948" || 589824

	}

}
