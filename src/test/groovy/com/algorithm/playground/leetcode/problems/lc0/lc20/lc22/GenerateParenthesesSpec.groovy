package com.algorithm.playground.leetcode.problems.lc0.lc20.lc22

import com.algorithm.playground.leetcode.problems.lc0.lc20.lc22.GenerateParentheses.Solution as S
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
