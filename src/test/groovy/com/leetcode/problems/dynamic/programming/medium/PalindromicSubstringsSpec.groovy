package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.PalindromicSubstrings.Solution
import spock.lang.Specification
import spock.lang.Unroll

class PalindromicSubstringsSpec extends Specification {

	@Unroll
	def "countSubstrings"() {

		expect:

			new Solution().countSubstrings(input) == output

		where:

			input          || output
			"abc"          || 3
			"aaa"          || 6
			"abcbadeedeed" || 21


	}

}
