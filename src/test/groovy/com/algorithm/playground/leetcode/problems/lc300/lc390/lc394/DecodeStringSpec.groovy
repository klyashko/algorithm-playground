package com.algorithm.playground.leetcode.problems.lc300.lc390.lc394

import com.algorithm.playground.leetcode.problems.lc300.lc390.lc394.DecodeString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
class DecodeStringSpec extends Specification {

	@Unroll
	def "decodeString"() {

		expect:

			new S().decodeString(s) == out

		where:

			s               || out
			"12[a]"         || "aaaaaaaaaaaa"
			"3[a]2[bc]"     || "aaabcbc"
			"3[a2[c]]"      || "accaccacc"
			"2[abc]3[cd]ef" || "abcabccdcdcdef"

	}

}