package com.algorithm.playground.leetcode.problems.lc100.lc170.lc174

import spock.lang.Specification
import spock.lang.Unroll

class DungeonGameSpec extends Specification {

	@Unroll
	def "calculateMinimumHP"() {

		expect:

			new DungeonGame.Solution().calculateMinimumHP(grid as int[][]) == out

		where:

			grid           || out
			[[-2, -3, 3],
			 [-5, -10, 1],
			 [10, 30, -5]] || 7
			[[100]]        || 1
			[[1, -3, 3],
			 [0, -2, 0],
			 [-3, -3, -3]] || 3

	}

	@Unroll
	def "calculateMinimumHP_DP"() {

		expect:

			new DungeonGame.SolutionDP().calculateMinimumHP(grid as int[][]) == output

		where:

			grid           || output
			[[-2, -3, 3],
			 [-5, -10, 1],
			 [10, 30, -5]] || 7
			[[100]]        || 1
			[[1, -3, 3],
			 [0, -2, 0],
			 [-3, -3, -3]] || 3

	}

}
