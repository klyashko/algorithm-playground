package com.algorithm.playground.leetcode.problems.lc500.lc594

import com.algorithm.playground.leetcode.problems.lc500.lc594.LongestHarmoniousSubsequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestHarmoniousSubsequenceSpec extends Specification {

	@Unroll
	def "findLHS"() {

		expect:

			new S().findLHS(nums as int[]) == out

		where:

			nums                     || out
			[1, 3, 2, 2, 5, 2, 3, 7] || 5
			[1, 1, 1, 1]             || 0

	}

}
