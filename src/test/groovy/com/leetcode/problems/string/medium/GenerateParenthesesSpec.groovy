package com.leetcode.problems.string.medium

import com.leetcode.problems.string.medium.GenerateParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class GenerateParenthesesSpec extends Specification {

	@Unroll
	def "generateParenthesis"() {

		expect:

			new S().generateParenthesis(n) == output

		where:

			n || output
			3 || ["((()))", "(()())", "(())()", "()(())", "()()()"]

	}

}
