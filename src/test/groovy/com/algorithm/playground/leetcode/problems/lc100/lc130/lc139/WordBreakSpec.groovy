package com.algorithm.playground.leetcode.problems.lc100.lc130.lc139

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc139.WordBreak.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
class WordBreakSpec extends Specification {

	@Unroll
	def "wordBreak"() {

		expect:

			new S().wordBreak(s, dict) == out

		where:

			s               | dict                                  || out
			"leetcode"      | ["leet", "code"]                      || true
			"applepenapple" | ["apple", "pen"]                      || true
			"catsandog"     | ["cats", "dog", "sand", "and", "cat"] || false

	}

}