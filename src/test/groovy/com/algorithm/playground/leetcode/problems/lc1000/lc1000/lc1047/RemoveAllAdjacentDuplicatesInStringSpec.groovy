package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1047

import com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1047.RemoveAllAdjacentDuplicatesInString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 *
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
 * and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */
class RemoveAllAdjacentDuplicatesInStringSpec extends Specification {

	@Unroll
	def "removeDuplicates"() {

		expect:

			new S().removeDuplicates(str) == out

		where:

			str      || out
			"abbaca" || "ca"

	}

}