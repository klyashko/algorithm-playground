package com.algorithm.playground.leetcode.problems.lc800.lc800.lc803

import com.algorithm.playground.leetcode.problems.lc800.lc800.lc803.BricksFallingWhenHit.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BricksFallingWhenHitSpec extends Specification {

	@Unroll
	def "hitBricks"() {

		expect:

			new S().hitBricks(grid as int[][], hits as int[][]) == output as int[]

		where:

			grid              | hits                                                                                     || output
			[[1, 0, 0, 0],
			 [1, 1, 1, 0]]    | [[1, 0]]                                                                                 || [2]
			[[1, 0, 0, 0],
			 [1, 1, 0, 0]]    | [[1, 1], [1, 0]]                                                                         || [0, 0]
			[[0, 1, 1, 1, 1],
			 [1, 1, 1, 1, 0],
			 [1, 1, 1, 1, 0],
			 [0, 0, 1, 1, 0],
			 [0, 0, 1, 0, 0],
			 [0, 0, 1, 0, 0],
			 [0, 0, 0, 0, 0],
			 [0, 0, 0, 0, 0],
			 [0, 0, 0, 0, 0]] | [[6, 0], [1, 0], [4, 3], [1, 2], [7, 1], [6, 3], [5, 2], [5, 1], [2, 4], [4, 4], [7, 3]] || [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
			[[1, 0, 1],
			 [1, 1, 1]]       | [[0, 0], [0, 2], [1, 1]]                                                                 || [0, 3, 0]
			[[1, 1, 0, 1, 0],
			 [1, 1, 0, 1, 1],
			 [0, 0, 0, 1, 1],
			 [0, 0, 0, 1, 0],
			 [0, 0, 0, 0, 0],
			 [0, 0, 0, 0, 0]] | [[5, 1], [1, 3]]                                                                         || [0, 4]

	}

}
