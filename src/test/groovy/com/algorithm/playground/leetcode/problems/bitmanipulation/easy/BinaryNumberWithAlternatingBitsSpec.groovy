package com.algorithm.playground.leetcode.problems.bitmanipulation.easy

import com.algorithm.playground.leetcode.problems.bitmanipulation.easy.BinaryNumberWithAlternatingBits.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BinaryNumberWithAlternatingBitsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "hasAlternatingBits"() {

		expect:

			new S().hasAlternatingBits(n) == output

		where:

			n  || output
			5  || true
			7  || false
			11 || false
			10 || true
			4  || false

	}

}
