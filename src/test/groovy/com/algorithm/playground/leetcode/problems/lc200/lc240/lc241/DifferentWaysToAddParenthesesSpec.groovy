package com.algorithm.playground.leetcode.problems.lc200.lc240.lc241

import spock.lang.Specification
import spock.lang.Unroll

class DifferentWaysToAddParenthesesSpec extends Specification {

	@Unroll
	def "diffWaysToCompute"() {

		expect:

			new DifferentWaysToAddParentheses.Solution().diffWaysToCompute(input) as Set == output as Set

		where:

			input     || output
			"2-1-1"   || [0, 2]
			"2*3-4*5" || [-34, -14, -10, -10, 10]
			"11"      || [11]
			"10+5"    || [15]

	}

}
