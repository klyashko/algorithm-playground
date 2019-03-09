package com.algorithm.playground.leetcode.problems.string.medium

import com.algorithm.playground.leetcode.problems.string.medium.ScoreOfParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ScoreOfParenthesesSpec extends Specification {

	@Unroll
	def "scoreOfParentheses"() {

		expect:

			new S().scoreOfParentheses(str) == output

		where:

			str        || output
			"()"       || 1
			"(())"     || 2
			"()()"     || 2
			"(()(()))" || 6
			"(())()"   || 3
			"((()()))" || 8

	}

}
