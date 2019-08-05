package com.algorithm.playground.leetcode.problems.lc0.lc10.lc17

import com.algorithm.playground.leetcode.problems.lc0.lc10.lc17.LetterCombinationsOfAPhoneNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
class LetterCombinationsOfAPhoneNumberSpec extends Specification {

	@Unroll
	def "letterCombinations"() {

		expect:

			new S().letterCombinations(digits) == out

		where:

			digits || out
			"23"   || ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

	}

}