package com.algorithm.playground.leetcode.problems.lc1000.lc1221

import com.algorithm.playground.leetcode.problems.lc1000.lc1221.SplitAStringInBalancedStrings.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SplitAStringInBalancedStringsSpec extends Specification {

	@Unroll
	def "balancedStringSplit"() {

		expect:

			new S().balancedStringSplit(s) == out

		where:

			s            || out
			"RLRRLLRLRL" || 4
			"RLLLLRRRLR" || 3
			"LLLLRRRR"   || 1

	}

}
