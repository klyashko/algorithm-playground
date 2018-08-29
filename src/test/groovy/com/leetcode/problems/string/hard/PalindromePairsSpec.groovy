package com.leetcode.problems.string.hard

import com.leetcode.problems.string.hard.PalindromePairs.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PalindromePairsSpec extends Specification {

	@Unroll
	def "palindromePairs"() {

		when:

			def s = new HashSet<>(output)
			def l = new S().palindromePairs(words as String[])

		then:

			l
			l.size() == s.size()
			!l.find { !(it in s) }
			!s.find { !(it in l) }

		where:

			words                                 || output
			["abcd", "dcba", "lls", "s", "sssll"] || [[1, 0], [0, 1], [3, 2], [2, 4]]
			["bat", "tab", "cat"]                 || [[1, 0], [0, 1]]
			["sl", "lls"]                         || [[0, 1]]
			["s", "lls"]                          || [[0, 1]]
			["a", ""]                             || [[0, 1], [1, 0]]

	}

}
