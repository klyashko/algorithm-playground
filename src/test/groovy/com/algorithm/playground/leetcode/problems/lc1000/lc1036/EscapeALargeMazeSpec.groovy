package com.algorithm.playground.leetcode.problems.lc1000.lc1036

import com.algorithm.playground.leetcode.problems.lc1000.lc1036.EscapeALargeMaze.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * Output: false
 * Explanation:
 * The target square is inaccessible starting from the source square, because we can't walk outside the grid.
 *
 *
 * Example 2:
 *
 * Input: blocked = [], source = [0,0], target = [999999,999999]
 * Output: true
 * Explanation:
 * Because there are no blocked cells, it's possible to reach the target square.
 *
 *
 * Note:
 *
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 */
class EscapeALargeMazeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isEscapePossible"() {

		expect:

			new S().isEscapePossible(blocked as int[][], source as int[], target as int[]) == out

		where:

			blocked          | source | target           || out
			[[0, 1], [1, 0]] | [0, 0] | [0, 2]           || false
			[]               | [0, 0] | [999999, 999999] || true

	}

}