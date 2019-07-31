package com.algorithm.playground.leetcode.problems.lc0.lc70.lc79

import com.algorithm.playground.leetcode.problems.lc0.lc70.lc79.WordSearch.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
class WordSearchSpec extends Specification {

	@Unroll
	def "exist"() {

		expect:

			new S().exist(board as char[][], word) == out

		where:

			board                  | word         || out
			[['A', 'B', 'C', 'E'],
			 ['S', 'F', 'C', 'S'],
			 ['A', 'D', 'E', 'E']] | "ABCCED"     || true
			[['A', 'B', 'C', 'E'],
			 ['S', 'F', 'C', 'S'],
			 ['A', 'D', 'E', 'E']] | "SEE"        || true
			[['A', 'B', 'C', 'E'],
			 ['S', 'F', 'C', 'S'],
			 ['A', 'D', 'E', 'E']] | "ABCB"       || false
			[["a"]]                | "a"          || true
			[["C", "A", "A"],
			 ["A", "A", "A"],
			 ["B", "C", "D"]]      | "AAB"        || true
			[["A", "B", "C", "E"],
			 ["S", "F", "E", "S"],
			 ["A", "D", "E", "E"]] | "ABCESEEEFS" || true
	}

}