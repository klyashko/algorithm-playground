package com.algorithm.playground.leetcode.problems.string.hard

import com.algorithm.playground.leetcode.problems.string.hard.ShortestPalindrome.Solution as S
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
