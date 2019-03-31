package com.algorithm.playground.leetcode.problems.lc0.lc40.lc46

import com.algorithm.playground.leetcode.problems.lc0.lc40.lc46.Permutations.Solution as S
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
