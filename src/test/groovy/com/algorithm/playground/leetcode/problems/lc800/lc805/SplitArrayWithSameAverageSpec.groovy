package com.algorithm.playground.leetcode.problems.lc800.lc805

import com.algorithm.playground.leetcode.problems.lc800.lc805.SplitArrayWithSameAverage.DynamicProgrammingSolution as DPS
import com.algorithm.playground.leetcode.problems.lc800.lc805.SplitArrayWithSameAverage.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SplitArrayWithSameAverageSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "splitArraySameAverage"() {

		expect:

			new S().splitArraySameAverage(a as int[]) == output

		where:

			a                                                                                                                                                         || output
			[1, 2, 3, 4, 5, 6, 7, 8]                                                                                                                                  || true
			[2, 0, 5, 6, 16, 12, 15, 12, 4]                                                                                                                           || true
			[6, 8, 18, 3, 1]                                                                                                                                          || false
			[0]                                                                                                                                                       || false
			[60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30]                                  || false
			[60, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30]                                  || true
			[18, 0, 16, 2]                                                                                                                                            || true
			[17, 5, 5, 1, 14, 10, 13, 1, 6]                                                                                                                           || true
			[3, 74, 86, 33, 50, 96, 79, 51, 27, 29, 80, 65, 19, 92, 58, 25, 59, 87, 61, 17, 89, 17]                                                                   || false
			[17, 3, 7, 12, 1]                                                                                                                                         || false
			[3863, 703, 1799, 327, 3682, 4330, 3388, 6187, 5330, 6572, 938, 6842, 678, 9837, 8256, 6886, 2204, 5262, 6643, 829, 745, 8755, 3549, 6627, 1633, 4290, 7] || false
			[3, 1]                                                                                                                                                    || false
			[]                                                                                                                                                        || false


	}

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "splitArraySameAverageDP"() {

		expect:

			new DPS().splitArraySameAverage(a as int[]) == output

		where:

			a                                                                                                                                                         || output
			[1, 2, 3, 4, 5, 6, 7, 8]                                                                                                                                  || true
			[2, 0, 5, 6, 16, 12, 15, 12, 4]                                                                                                                           || true
			[6, 8, 18, 3, 1]                                                                                                                                          || false
			[0]                                                                                                                                                       || false
			[60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30]                                  || false
			[60, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30]                                  || true
			[18, 0, 16, 2]                                                                                                                                            || true
			[17, 5, 5, 1, 14, 10, 13, 1, 6]                                                                                                                           || true
			[3, 74, 86, 33, 50, 96, 79, 51, 27, 29, 80, 65, 19, 92, 58, 25, 59, 87, 61, 17, 89, 17]                                                                   || false
			[17, 3, 7, 12, 1]                                                                                                                                         || false
			[3863, 703, 1799, 327, 3682, 4330, 3388, 6187, 5330, 6572, 938, 6842, 678, 9837, 8256, 6886, 2204, 5262, 6643, 829, 745, 8755, 3549, 6627, 1633, 4290, 7] || false
			[3, 1]                                                                                                                                                    || false
			[]                                                                                                                                                        || false


	}

}
