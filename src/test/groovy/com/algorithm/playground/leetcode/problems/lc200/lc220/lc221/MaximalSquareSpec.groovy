package com.algorithm.playground.leetcode.problems.lc200.lc220.lc221

import com.algorithm.playground.leetcode.problems.lc200.lc220.lc221.MaximalSquare.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
class MaximalSquareSpec extends Specification {

	@Unroll
	def "maximalSquare"() {

		expect:

			new S().maximalSquare(matrix as char[][]) == out

		where:

			matrix                      || out
			[['1', '0', '1', '0', '0'],
			 ['1', '0', '1', '1', '1'],
			 ['1', '1', '1', '1', '1'],
			 ['1', '0', '0', '1', '0']] || 4
			[["0", "0", "0", "1"],
			 ["1", "1", "0", "1"],
			 ["1", "1", "1", "1"],
			 ["0", "1", "1", "1"],
			 ["0", "1", "1", "1"]]      || 9
			[["1", "0"],
			 ["1", "0"]]                || 1
			[["0", "0", "1", "0"],
			 ["1", "1", "1", "1"],
			 ["1", "1", "1", "1"],
			 ["1", "1", "1", "0"],
			 ["1", "1", "0", "0"],
			 ["1", "1", "1", "1"],
			 ["1", "1", "1", "0"]]      || 9
			[["1"]]                     || 1
			[["1", "1", "0", "1"],
			 ["1", "1", "0", "1"],
			 ["1", "1", "1", "1"]]      || 4
	}

}