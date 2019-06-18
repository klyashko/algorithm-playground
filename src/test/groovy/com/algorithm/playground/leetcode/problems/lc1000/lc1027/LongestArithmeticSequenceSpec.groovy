package com.algorithm.playground.leetcode.problems.lc1000.lc1027

import com.algorithm.playground.leetcode.problems.lc1000.lc1027.LongestArithmeticSequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestArithmeticSequenceSpec extends Specification {

	@Unroll
	def "longestArithSeqLength"() {

		expect:

			new S().longestArithSeqLength(A as int[]) == out

		where:

			A                        || out
			[3, 6, 9, 12]            || 4
			[9, 4, 7, 2, 10]         || 3
			[20, 1, 15, 3, 10, 5, 8] || 4

	}

}
