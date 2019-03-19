package com.algorithm.playground.leetcode.problems.lc300.lc300.lc301

import spock.lang.Specification
import spock.lang.Unroll

class RemoveInvalidParenthesesSpec extends Specification {

	@Unroll
	def "removeInvalidParentheses"() {

		expect:

			new RemoveInvalidParentheses.Solution().removeInvalidParentheses(s) as Set == output as Set

		where:

			s          || output
			"())"      || ["()"]
			"()())()"  || ["()()()", "(())()"]
			"(a)())()" || ["(a)()()", "(a())()"]
			")("       || [""]
			"x("       || ["x"]
			")()("     || ["()"]
	}

}
