package com.algorithm.playground.leetcode.problems.lc400.lc460.lc461

import com.algorithm.playground.leetcode.problems.lc400.lc460.lc461.HammingDistance.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class HammingDistanceSpec extends Specification {

	@Unroll
	def "hammingDistance"() {

		expect:

			new S().hammingDistance(x, y) == output

		where:

			x | y || output
			1 | 4 || 2

	}

	@Unroll
	def "hammingDistance_fast"() {

		expect:

			new S().hammingDistance(x, y) == output

		where:

			x | y || output
			1 | 4 || 2

	}

}
