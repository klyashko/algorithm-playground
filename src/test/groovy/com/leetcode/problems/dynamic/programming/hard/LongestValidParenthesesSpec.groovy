package com.leetcode.problems.dynamic.programming.hard

import com.leetcode.problems.dynamic.programming.hard.LongestValidParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestValidParenthesesSpec extends Specification {

	@Unroll
	def "longestValidParentheses"() {

		expect:

			new S().longestValidParentheses(str) == output

		where:

			str                        || output
			"(()"                      || 2
			")()())"                   || 4
			"(()()()(((()()()()()((((" || 10


	}

}
