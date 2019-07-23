package com.algorithm.playground.leetcode.problems.lc400.lc400.lc402

import com.algorithm.playground.leetcode.problems.lc400.lc400.lc402.RemoveKDigits.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 *
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
class RemoveKDigitsSpec extends Specification {

	@Unroll
	def "removeKdigits"() {

		expect:

			new S().removeKdigits(nums, k) == out

		where:

			nums      | k || out
			"1432219" | 3 || "1219"
			"10200"   | 1 || "200"
			"10"      | 2 || "0"
			"9"       | 1 || "0"
			"112"     | 1 || "11"
			"1111111" | 3 || "1111"
			"4321"    | 2 || "21"
			"1107"    | 1 || "107"

	}

}