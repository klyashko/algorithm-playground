package com.algorithm.playground.leetcode.problems.math.medium

import com.algorithm.playground.leetcode.problems.math.medium.ReorderedPowerOf2.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReorderedPowerOf2Spec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "reorderedPowerOf2"() {

		expect:

			new S().reorderedPowerOf2(n) == output

		where:

			n  || output
			1  || true
			10 || false
			16 || true
			24 || false
			46 || true

	}

}
