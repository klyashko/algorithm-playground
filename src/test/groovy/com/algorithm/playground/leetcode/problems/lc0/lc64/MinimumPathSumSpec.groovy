package com.algorithm.playground.leetcode.problems.lc0.lc64

import com.algorithm.playground.leetcode.problems.lc0.lc64.MinimumPathSum
import spock.lang.Specification
import spock.lang.Unroll

class MinimumPathSumSpec extends Specification {

	@Unroll
	def "minPathSum"() {

		expect:

			new MinimumPathSum.Solution().minPathSum(grid as int[][]) == out

		where:

			grid        || out
			[[1, 3, 1],
			 [1, 5, 1],
			 [4, 2, 1]] || 7

	}

}
