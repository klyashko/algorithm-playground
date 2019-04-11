package com.algorithm.playground.leetcode.problems.lc800.lc850.lc854

import spock.lang.Specification
import spock.lang.Unroll

class KSimilarStringsSpec extends Specification {

	@Unroll
	def "kSimilarity"() {

		expect:

			new KSimilarStrings.Solution().kSimilarity(A, B) == output

		where:

			A                      | B                      || output
			"ab"                   | "ba"                   || 1
			"abc"                  | "bca"                  || 2
			"abac"                 | "baca"                 || 2
			"aabc"                 | "abca"                 || 2
			"abccaacceecdeea"      | "bcaacceeccdeaae"      || 9
			"abcdeabcdeabcdeabcde" | "aaaabbbbccccddddeeee" || 8
			"abccab"               | "abccab"               || 0

	}

}
