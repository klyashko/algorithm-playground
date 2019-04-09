package com.algorithm.playground.leetcode.problems.lc0.lc20.lc20

import com.algorithm.playground.leetcode.problems.lc0.lc20.lc20.ValidParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ValidParenthesesSpec extends Specification {

	@Unroll
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
