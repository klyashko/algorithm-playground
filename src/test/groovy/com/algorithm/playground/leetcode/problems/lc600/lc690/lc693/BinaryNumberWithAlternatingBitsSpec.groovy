package com.algorithm.playground.leetcode.problems.lc600.lc690.lc693

import com.algorithm.playground.leetcode.problems.lc600.lc690.lc693.BinaryNumberWithAlternatingBits.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BinaryNumberWithAlternatingBitsSpec extends Specification {

	@Unroll
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
