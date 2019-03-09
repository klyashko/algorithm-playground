package com.algorithm.playground.leetcode.problems.array.medium

import com.algorithm.playground.leetcode.problems.array.medium.MinimumIncrementToMakeArrayUnique.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumIncrementToMakeArrayUniqueSpec extends Specification {

	@Unroll
	def "minIncrementForUnique"() {

		expect:

			new S().minIncrementForUnique(a as int[]) == out

		where:

			a                  || out
			[1, 2, 2]          || 1
			[3, 2, 1, 2, 1, 7] || 6
			[]                 || 0
			[2, 2, 2, 1]       || 3
			[2, 2, 2, 2, 0]    || 6

	}

}
