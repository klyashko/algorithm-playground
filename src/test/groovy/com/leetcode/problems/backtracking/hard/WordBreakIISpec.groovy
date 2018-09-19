package com.leetcode.problems.backtracking.hard

import com.leetcode.problems.backtracking.hard.WordBreakII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class WordBreakIISpec extends Specification {

	@Unroll
	def "wordBreak"() {

		expect:

			new S().wordBreak(str, words) as Set == output as Set

		where:

			str                                                                                                                                                       | words                                                                                           || output
//			"catsanddog"                                                                                                                                              | ["cat", "cats", "and", "sand", "dog"]                                                           || ["cats and dog",
//																																																																			"cat sand dog"]
//			"pineapplepenapple"                                                                                                                                       | ["apple", "pen", "applepen", "pine", "pineapple"]                                               || ["pine apple pen apple",
//																																																																			"pineapple pen apple",
//																																																																			"pine applepen apple"]
//			"catsandog"                                                                                                                                               | ["cats", "dog", "sand", "and", "cat"]                                                           || []
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" | ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"] || []

	}

}
