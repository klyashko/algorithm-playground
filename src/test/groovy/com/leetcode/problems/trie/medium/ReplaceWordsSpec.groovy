package com.leetcode.problems.trie.medium

import com.leetcode.problems.trie.medium.ReplaceWords.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReplaceWordsSpec extends Specification {

	@Unroll
	def "replaceWords"() {

		expect:

			new S().replaceWords(dict, sentense) == output

		where:

			dict                  | sentense                                || output
			["cat", "bat", "rat"] | "the cattle was rattled by the battery" || "the cat was rat by the bat"

	}

}
