package com.algorithm.playground.leetcode.problems.lc600.lc670.lc678

import com.algorithm.playground.leetcode.problems.lc600.lc670.lc678.ValidParenthesisString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidParenthesisStringSpec extends Specification {

	@Unroll
	def "checkValidString"() {

		expect:

			new S().checkValidString(s) == out

		where:

			s      || out
			"()"   || true
			"(*)"  || true
			"(*))" || true

	}

}
