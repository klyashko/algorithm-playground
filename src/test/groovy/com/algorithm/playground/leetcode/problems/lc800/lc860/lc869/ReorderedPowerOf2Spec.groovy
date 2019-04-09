package com.algorithm.playground.leetcode.problems.lc800.lc860.lc869

import com.algorithm.playground.leetcode.problems.lc800.lc860.lc869.ReorderedPowerOf2.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReorderedPowerOf2Spec extends Specification {

	@Unroll
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
