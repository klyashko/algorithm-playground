package com.leetcode.problems.divideandconquer.medium

import com.leetcode.problems.divideandconquer.medium.DifferentWaysToAddParentheses.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class DifferentWaysToAddParenthesesSpec extends Specification {

	@Unroll
	def "diffWaysToCompute"() {

		expect:

			new S().diffWaysToCompute(input) as Set == output as Set

		where:

			input     || output
			"2-1-1"   || [0, 2]
			"2*3-4*5" || [-34, -14, -10, -10, 10]
			"11"      || [11]
			"10+5"    || [15]

	}

}
