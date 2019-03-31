package com.algorithm.playground.leetcode.problems.lc700.lc780.lc786

import com.algorithm.playground.leetcode.problems.lc700.lc780.lc786.KthSmallestPrimeFraction.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KthSmallestPrimeFractionSpec extends Specification {

	@Unroll
	def "kthSmallestPrimeFraction"() {

		expect:

			new S().kthSmallestPrimeFraction(A as int[], K) == output as int[]

		where:

			A               | K || output
			[1, 2, 3, 5]    | 3 || [2, 5]
			[1, 7]          | 1 || [1, 7]
			[1, 79]         | 1 || [1, 79]
			[1, 13, 17, 59] | 6 || [13, 17]

	}

}
