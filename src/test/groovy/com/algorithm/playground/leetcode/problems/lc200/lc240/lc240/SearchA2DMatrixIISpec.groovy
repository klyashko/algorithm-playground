package com.algorithm.playground.leetcode.problems.lc200.lc240.lc240

import com.algorithm.playground.leetcode.problems.lc200.lc240.lc240.SearchA2DMatrixII
import spock.lang.Specification
import spock.lang.Unroll

class SearchA2DMatrixIISpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "searchMatrix"() {

		expect:

			new SearchA2DMatrixII.Solution().searchMatrix(matrix as int[][], target) == output

		where:

			matrix                 | target || output
			[[1, 4, 7, 11, 15],
			 [2, 5, 8, 12, 19],
			 [3, 6, 9, 16, 22],
			 [10, 13, 14, 17, 24],
			 [18, 21, 23, 26, 30]] | 5      || true
			[[1, 4, 7, 11, 15],
			 [2, 5, 8, 12, 19],
			 [3, 6, 9, 16, 22],
			 [10, 13, 14, 17, 24],
			 [18, 21, 23, 26, 30]] | 20     || false
			[]                     | 1      || false
			[[]]                   | 1      || false

	}

}
