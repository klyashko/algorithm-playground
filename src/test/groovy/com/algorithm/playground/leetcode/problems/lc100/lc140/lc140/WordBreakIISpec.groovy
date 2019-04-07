package com.algorithm.playground.leetcode.problems.lc100.lc140.lc140

import com.algorithm.playground.leetcode.problems.lc100.lc140.lc140.WordBreakII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class WordBreakIISpec extends Specification {

	@Unroll
	def "wordBreak"() {

		expect:

			new S().wordBreak(str, words) as Set == output as Set

		where:

			str                                                                                                                                                       | words                                                                                           || output
			"catsanddog"                                                                                                                                              | ["cat", "cats", "and", "sand", "dog"]                                                           || ["cats and dog",
																																																																			"cat sand dog"]
			"pineapplepenapple"                                                                                                                                       | ["apple", "pen", "applepen", "pine", "pineapple"]                                               || ["pine apple pen apple",
																																																																			"pineapple pen apple",
																																																																			"pine applepen apple"]
			"catsandog"                                                                                                                                               | ["cats", "dog", "sand", "and", "cat"]                                                           || []
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" | ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"] || []
			"aaaaaaa"                                                                                                                                                 | ["aaaa", "aaa"]                                                                                 || ["aaaa aaa", "aaa aaaa"]
			"aaaaaaaa"                                                                                                                                                | ["aaaa", "aa", "a"]                                                                             || ["a a a a a a a a", "aa a a a a a a", "a aa a a a a a", "a a aa a a a a", "aa aa a a a a", "aaaa a a a a", "a a a aa a a a", "aa a aa a a a", "a aa aa a a a", "a aaaa a a a", "a a a a aa a a", "aa a a aa a a", "a aa a aa a a", "a a aa aa a a", "aa aa aa a a", "aaaa aa a a", "a a aaaa a a", "aa aaaa a a", "a a a a a aa a", "aa a a a aa a", "a aa a a aa a", "a a aa a aa a", "aa aa a aa a", "aaaa a aa a", "a a a aa aa a", "aa a aa aa a", "a aa aa aa a", "a aaaa aa a", "a a a aaaa a", "aa a aaaa a", "a aa aaaa a", "a a a a a a aa", "aa a a a a aa", "a aa a a a aa", "a a aa a a aa", "aa aa a a aa", "aaaa a a aa", "a a a aa a aa", "aa a aa a aa", "a aa aa a aa", "a aaaa a aa", "a a a a aa aa", "aa a a aa aa", "a aa a aa aa", "a a aa aa aa", "aa aa aa aa", "aaaa aa aa", "a a aaaa aa", "aa aaaa aa", "a a a a aaaa", "aa a a aaaa", "a aa a aaaa", "a a aa aaaa", "aa aa aaaa", "aaaa aaaa"]
			"bb"                                                                                                                                                      | ["a", "b", "bbb", "bbbb"]                                                                       || ["b b"]

	}

}
