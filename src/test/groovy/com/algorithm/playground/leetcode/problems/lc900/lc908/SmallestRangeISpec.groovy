package com.algorithm.playground.leetcode.problems.lc900.lc908

import com.algorithm.playground.leetcode.problems.lc900.lc908.SmallestRangeI.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SmallestRangeISpec extends Specification {

	@Unroll
	def "smallestRangeI"() {

		expect:

			new S().smallestRangeI(A as int[], K) == out

		where:

			A         | K || out
			[1]       | 0 || 0
			[0, 10]   | 2 || 6
			[1, 3, 6] | 3 || 0

	}

}
