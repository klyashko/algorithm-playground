package com.leetcode.problems.breadthfirstsearch.hard

import com.leetcode.problems.breadthfirstsearch.hard.KSimilarStrings.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KSimilarStringsSpec extends Specification {

	@Unroll
	def "kSimilarity"() {

		expect:

			new S().kSimilarity(A, B) == output

		where:

			A                      | B                      || output
			"ab"                   | "ba"                   || 1
			"abc"                  | "bca"                  || 2
			"abac"                 | "baca"                 || 2
			"aabc"                 | "abca"                 || 2
			"abccaacceecdeea"      | "bcaacceeccdeaae"      || 9
			"abcdeabcdeabcdeabcde" | "aaaabbbbccccddddeeee" || 8

	}

}
