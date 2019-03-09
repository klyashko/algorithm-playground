package com.algorithm.playground.leetcode.problems.binarysearch.hard

import com.algorithm.playground.leetcode.problems.binarysearch.hard.DungeonGame.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class DungeonGameSpec extends Specification {

	@Unroll
	def "calculateMinimumHP"() {

		expect:

			new S().calculateMinimumHP(grid as int[][]) == out

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

}
