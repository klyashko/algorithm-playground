package com.leetcode.problems.dynamicprogramming.medium

import com.leetcode.problems.dynamicprogramming.medium.MinimumPathSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumPathSumSpec extends Specification {

	@Unroll
	def "minPathSum"() {

		expect:

			new S().minPathSum(grid as int[][]) == out

		where:

			grid        || out
			[[1, 3, 1],
			 [1, 5, 1],
			 [4, 2, 1]] || 7

	}

}
