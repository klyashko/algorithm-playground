package com.algorithm.playground.leetcode.problems.lc200.lc210.lc214

import com.algorithm.playground.leetcode.problems.lc200.lc210.lc214.ShortestPalindrome.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ShortestPalindromeSpec extends Specification {

	@Unroll
	def "shortestPalindrome"() {

		expect:

			new S().shortestPalindrome(str) == output

		where:

			str        || output
			"aacecaaa" || "aaacecaaa"
			"abcd"     || "dcbabcd"
			"a"        || "a"
			""         || ""
			"ba"       || "aba"
			"aba"      || "aba"
			"aabba"    || "abbaabba"

	}

}
