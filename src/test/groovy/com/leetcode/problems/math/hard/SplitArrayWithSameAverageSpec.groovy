package com.leetcode.problems.math.hard

import com.leetcode.problems.math.hard.SplitArrayWithSameAverage.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SplitArrayWithSameAverageSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "splitArraySameAverage"() {

		expect:

			new S().splitArraySameAverage(a as int[]) == output

		where:

			a                                                                                                                        || output
			[1, 2, 3, 4, 5, 6, 7, 8]                                                                                                 || true
			[2, 0, 5, 6, 16, 12, 15, 12, 4]                                                                                          || true
			[6, 8, 18, 3, 1]                                                                                                         || false
			[0]                                                                                                                      || false
			[60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30] || false
			[60, 60, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30] || true
			[18, 0, 16, 2]                                                                                                           || true
			[17, 5, 5, 1, 14, 10, 13, 1, 6]                                                                                          || true


	}

}
