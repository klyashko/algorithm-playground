package com.algorithm.playground.leetcode.problems.lc921

import com.algorithm.playground.leetcode.problems.lc921.MinimumAddToMakeParenthesesValid.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumAddToMakeParenthesesValidSpec extends Specification {

	@Unroll
	def "minAddToMakeValid"() {

		expect:

			new S().minAddToMakeValid(s) == out

		where:

			s        || out
			"())"    || 1
			"((("    || 3
			"()"     || 0
			"()))((" || 4

	}

}
