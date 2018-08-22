package com.leetcode.problems.dynamic.programming.hard

import com.leetcode.problems.dynamic.programming.hard.DungeonGame.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class DungeonGameSpec extends Specification {

	@Unroll
	def "calculateMinimumHP"() {

		expect:

			new S().calculateMinimumHP(grid as int[][]) == output

		where:

			grid                                      || output
			[[-2, -3, 3], [-5, -10, 1], [10, 30, -5]] || 7

	}

}
