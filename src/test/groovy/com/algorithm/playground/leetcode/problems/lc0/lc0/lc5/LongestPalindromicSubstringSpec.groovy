package com.algorithm.playground.leetcode.problems.lc0.lc0.lc5

import com.algorithm.playground.leetcode.problems.lc0.lc0.lc5.LongestPalindromicSubstring.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
class LongestPalindromicSubstringSpec extends Specification {

	@Unroll
	def "longestPalindrome"() {

		expect:

			new S().longestPalindrome(s) == out

		where:

			s                       || out
			"babad"                 || "bab"
			"efgabacdcabacdcabaxyz" || "abacdcabacdcaba"
			"efgabacdcabacdcabcxyz" || "bacdcabacdcab"
			"cbbd"                  || "bb"
			""                      || ""
			"abb"                   || "bb"
			"bba"                   || "bb"
			"ac"                    || "a"
			"ccc"                   || "ccc"

	}

}