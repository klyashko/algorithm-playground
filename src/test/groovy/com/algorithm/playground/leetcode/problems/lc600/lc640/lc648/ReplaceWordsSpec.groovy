package com.algorithm.playground.leetcode.problems.lc600.lc640.lc648

import com.algorithm.playground.leetcode.problems.lc600.lc640.lc648.ReplaceWords.Solution as S
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
