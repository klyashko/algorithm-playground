package com.leetcode.problems.string.medium

import com.leetcode.problems.string.medium.ValidParenthesisString.Solution as S
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
