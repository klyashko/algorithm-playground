package com.algorithm.playground.leetcode.problems.depthfirstsearch.hard


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
