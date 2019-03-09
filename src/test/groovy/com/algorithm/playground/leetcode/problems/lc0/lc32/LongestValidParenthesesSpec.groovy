package com.algorithm.playground.leetcode.problems.lc0.lc32

import com.algorithm.playground.leetcode.problems.lc0.lc32.LongestValidParentheses
import spock.lang.Specification
import spock.lang.Unroll

class LongestValidParenthesesSpec extends Specification {

	@Unroll
	def "longestValidParentheses"() {

		expect:

			new LongestValidParentheses.Solution().longestValidParentheses(str) == output

		where:

			str                        || output
			"(()"                      || 2
			")()())"                   || 4
			"(()()()(((()()()()()((((" || 10


	}

}
