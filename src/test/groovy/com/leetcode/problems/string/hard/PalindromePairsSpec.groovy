package com.leetcode.problems.string.hard

import com.leetcode.problems.string.hard.PalindromePairs.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PalindromePairsSpec extends Specification {

	@Unroll
	def "palindromePairs"() {

		expect:

			new S().palindromePairs(words as String[]) == output

		where:

			words                                 || output
			["abcd", "dcba", "lls", "s", "sssll"] || [[0, 1], [1, 0], [3, 2], [2, 4]]
			["bat", "tab", "cat"]                 || [[0, 1], [1, 0]]

	}

}
