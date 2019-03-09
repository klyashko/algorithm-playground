package com.algorithm.playground.leetcode.problems.string.easy

import com.algorithm.playground.leetcode.problems.string.easy.JudgeRouteCircle.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class JudgeRouteCircleSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
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
