package com.algorithm.playground.leetcode.problems.backtracking.medium

import com.algorithm.playground.leetcode.problems.backtracking.medium.Permutations.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PermutationsSpec extends Specification {

	@Unroll
	def "permute"() {

		expect:

			new S().permute(nums as int[]) as Set == output as Set

		where:

			nums      || output
			[1, 2, 3] || [[1, 2, 3],
						  [1, 3, 2],
						  [2, 1, 3],
						  [2, 3, 1],
						  [3, 1, 2],
						  [3, 2, 1]]

	}

}
