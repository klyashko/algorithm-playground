package com.algorithm.playground.leetcode.problems.math.medium

import com.algorithm.playground.leetcode.problems.math.medium.MaximumSwap.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximumSwapSpec extends Specification {

	@Unroll
	def "maximumSwap"() {

		expect:

			new S().maximumSwap(n) == output

		where:

			n    || output
			2736 || 7236
			9973 || 9973
			1993 || 9913

	}

}
