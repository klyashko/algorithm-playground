package com.algorithm.playground.leetcode.problems.lc400.lc400.lc409

import com.algorithm.playground.leetcode.problems.lc400.lc400.lc409.LongestPalindrome.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestPalindromeSpec extends Specification {

	@Unroll
	def "longestPalindrome"() {

		expect:

			new S().longestPalindrome(s) == out

		where:

			s          || out
			"abccccdd" || 7

	}

}
