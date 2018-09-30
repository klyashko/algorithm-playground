package com.leetcode.problems.dynamicprogramming.medium

import spock.lang.Specification
import spock.lang.Unroll

class PalindromicSubstringsSpec extends Specification {

	@Unroll
	def "countSubstrings"() {

		expect:

			new PalindromicSubstrings.Solution().countSubstrings(input) == output

		where:

			input          || output
			"abc"          || 3
			"aaa"          || 6
			"abcbadeedeed" || 21


	}

}
