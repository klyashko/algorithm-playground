package com.algorithm.playground.leetcode.problems.stack.easy

import com.algorithm.playground.leetcode.problems.stack.easy.ValidParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidParenthesesSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isValid"() {

		expect:

			new S().isValid(str) == output

		where:

			str      || output
			"()"     || true
			"()[]{}" || true
			"(]"     || false
			"([)]"   || false
			"{[]}"   || true

	}

}
