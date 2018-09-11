package com.leetcode.problems.depthfirstsearch.hard

import com.leetcode.problems.depthfirstsearch.hard.RemoveInvalidParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RemoveInvalidParenthesesSpec extends Specification {

	@Unroll
	def "removeInvalidParentheses"() {

		expect:

			new S().removeInvalidParentheses(s) as Set == output as Set

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
