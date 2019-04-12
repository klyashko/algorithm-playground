package com.algorithm.playground.leetcode.problems.lc600.lc650.lc657

import com.algorithm.playground.leetcode.problems.lc600.lc650.lc657.JudgeRouteCircle.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class JudgeRouteCircleSpec extends Specification {

	@Unroll
	def "judgeCircle"() {

		expect:

			new S().judgeCircle(moves) == output

		where:

			moves        || output
			"UD"         || true
			"LL"         || false
			"RURULLLDRD" || true
			"RLUURDDDLU" || true

	}

}
