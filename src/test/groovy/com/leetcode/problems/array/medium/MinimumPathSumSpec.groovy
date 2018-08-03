package com.leetcode.problems.array.medium

import com.leetcode.problems.array.medium.MinimumPathSum.Solution
import spock.lang.Specification

class MinimumPathSumSpec extends Specification {

	def "minPathSum"() {
		expect:
			new Solution().minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]] as int[][]) == 7
	}

}
