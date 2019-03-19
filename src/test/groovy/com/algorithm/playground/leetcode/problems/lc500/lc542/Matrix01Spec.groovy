package com.algorithm.playground.leetcode.problems.lc500.lc542

import com.algorithm.playground.leetcode.problems.lc500.lc542.Matrix01.DFSSolution as DFSS
import com.algorithm.playground.leetcode.problems.lc500.lc542.Matrix01.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class Matrix01Spec extends Specification {

	@Unroll
	def "updateMatrix"() {

		expect:

			new S().updateMatrix(maptix as int[][]) == out as int[][]

		where:

			maptix      || out
			[[0, 0, 0],
			 [0, 1, 0],
			 [0, 0, 0]] || [[0, 0, 0],
							[0, 1, 0],
							[0, 0, 0]]
			[[0, 0, 0],
			 [0, 1, 0],
			 [1, 1, 1]] || [[0, 0, 0],
							[0, 1, 0],
							[1, 2, 1]]

	}

	@Unroll
	def "updateMatrix_dfs"() {

		expect:

			new DFSS().updateMatrix(maptix as int[][]) == out as int[][]

		where:

			maptix      || out
			[[0, 0, 0],
			 [0, 1, 0],
			 [0, 0, 0]] || [[0, 0, 0],
							[0, 1, 0],
							[0, 0, 0]]
			[[0, 0, 0],
			 [0, 1, 0],
			 [1, 1, 1]] || [[0, 0, 0],
							[0, 1, 0],
							[1, 2, 1]]

	}

}
