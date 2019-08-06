package com.algorithm.playground.leetcode.problems.lc0.lc40.lc48

import com.algorithm.playground.leetcode.problems.lc0.lc40.lc48.RotateImage.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
class RotateImageSpec extends Specification {

	@Unroll
	def "rotate"() {

		given:

			def matrix = values as int[][]

		when:

			new S().rotate(matrix)
			println(matrix)

		then:

			matrix.toString() == (out as int[][]).toString()

		where:

			values             || out
			[[1, 2, 3],
			 [4, 5, 6],
			 [7, 8, 9]]        || [[7, 4, 1],
								   [8, 5, 2],
								   [9, 6, 3]]
			[[5, 1, 9, 11],
			 [2, 4, 8, 10],
			 [13, 3, 6, 7],
			 [15, 14, 12, 16]] || [[15, 13, 2, 5],
								   [14, 3, 4, 1],
								   [12, 6, 8, 9],
								   [16, 7, 10, 11]]

	}

}