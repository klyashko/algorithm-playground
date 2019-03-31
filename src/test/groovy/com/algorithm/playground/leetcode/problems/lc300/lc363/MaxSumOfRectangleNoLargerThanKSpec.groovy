package com.algorithm.playground.leetcode.problems.lc300.lc363

import com.algorithm.playground.leetcode.problems.lc300.lc363.MaxSumOfRectangleNoLargerThanK.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaxSumOfRectangleNoLargerThanKSpec extends Specification {

	@Unroll
	def "maxSumSubmatrix"() {

		expect:

			new S().maxSumSubmatrix(matrix as int[][], k) == output

		where:

			matrix       | k || output
			[[1, 0, 1],
			 [0, -2, 3]] | 2 || 2
			[[1, 0, 1],
			 [0, -2, 3]] | 5 || 4
			[[1, 0, 1],
			 [0, -2, 3]] | 3 || 3
			[[2, 2, -1]] | 0 || -1

	}

}
