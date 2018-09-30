package com.leetcode.problems.dynamicprogramming.hard

import spock.lang.Specification
import spock.lang.Unroll

class DungeonGameSpec extends Specification {

	@Unroll
	def "calculateMinimumHP"() {

		expect:

			new DungeonGame.Solution().calculateMinimumHP(grid as int[][]) == output

		where:

			grid                                      || output
			[[-2, -3, 3], [-5, -10, 1], [10, 30, -5]] || 7

	}

}
