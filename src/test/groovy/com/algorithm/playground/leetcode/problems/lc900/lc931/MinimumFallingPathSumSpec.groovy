package com.algorithm.playground.leetcode.problems.lc900.lc931

import com.algorithm.playground.leetcode.problems.lc900.lc931.MinimumFallingPathSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 *
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 *
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 *
 * [[1,2,3],
 *  [4,5,6],
 *  [7,8,9]]
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
class MinimumFallingPathSumSpec extends Specification {

	@Unroll
	def "minFallingPathSum"() {

		expect:

			new S().minFallingPathSum(A as int[][]) == out

		where:

			A           || out
			[[1, 2, 3],
			 [4, 5, 6],
			 [7, 8, 9]] || 12
			[[-19, 57],
			 [-40, -5]] || -59

	}

}
