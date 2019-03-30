package com.algorithm.playground.leetcode.problems.lc600.lc690.lc699

import com.algorithm.playground.leetcode.problems.lc600.lc690.lc699.FallingSquares.SegmentTreeSolution as STS
import com.algorithm.playground.leetcode.problems.lc600.lc690.lc699.FallingSquares.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FallingSquaresSpec extends Specification {

	@Unroll
	def "fallingSquares"() {

		expect:

			new S().fallingSquares(positionas as int[][]) == output

		where:

			positionas                                                                                          || output
			[[1, 2], [2, 3], [6, 1]]                                                                            || [2, 5, 5]
			[[100, 100], [200, 100]]                                                                            || [100, 100]
			[[6, 1], [9, 2], [2, 4]]                                                                            || [1, 2, 4]
			[[9, 7], [1, 9], [3, 1]]                                                                            || [7, 16, 17]
			[[50, 47], [95, 48], [88, 77], [84, 3], [53, 87], [98, 79], [88, 28], [13, 22], [53, 73], [85, 55]] || [47, 95, 172, 172, 259, 338, 366, 366, 439, 494]


	}

	@Unroll
	def "fallingSquares_segment_tree"() {

		expect:

			new STS().fallingSquares(positionas as int[][]) == output

		where:

			positionas                                                                                          || output
			[[1, 2], [2, 3], [6, 1]]                                                                            || [2, 5, 5]
			[[100, 100], [200, 100]]                                                                            || [100, 100]
			[[6, 1], [9, 2], [2, 4]]                                                                            || [1, 2, 4]
			[[9, 7], [1, 9], [3, 1]]                                                                            || [7, 16, 17]
			[[50, 47], [95, 48], [88, 77], [84, 3], [53, 87], [98, 79], [88, 28], [13, 22], [53, 73], [85, 55]] || [47, 95, 172, 172, 259, 338, 366, 366, 439, 494]


	}

}
