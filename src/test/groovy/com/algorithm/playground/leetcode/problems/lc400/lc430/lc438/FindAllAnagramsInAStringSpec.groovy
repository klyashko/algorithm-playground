package com.algorithm.playground.leetcode.problems.lc400.lc430.lc438

import com.algorithm.playground.leetcode.problems.lc400.lc430.lc438.FindAllAnagramsInAString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
class FindAllAnagramsInAStringSpec extends Specification {

	@Unroll
	def "findAnagrams"() {

		expect:

			new S().findAnagrams(s, p) == out

		where:

			s            | p               || out
			"cbaebabacd" | "abc"           || [0, 6]
			"abab"       | "ab"            || [0, 1, 2]
			"aaaaaaaaaa" | "aaaaaaaaaaaaa" || []

	}

}