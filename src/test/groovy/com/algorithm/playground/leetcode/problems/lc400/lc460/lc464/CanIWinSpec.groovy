package com.algorithm.playground.leetcode.problems.lc400.lc460.lc464

import com.algorithm.playground.leetcode.problems.lc400.lc460.lc464.CanIWin.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example
 *
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 */
class CanIWinSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canIWin"() {

		expect:

			new S().canIWin(max, total) == out

		where:

			max | total || out
			10  | 11    || false
			18  | 188   || false
			10  | 40    || false
			10  | 0     || true
			4   | 6     || true
			18  | 79    || true

	}

}
