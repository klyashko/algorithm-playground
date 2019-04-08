package com.algorithm.playground.leetcode.problems.lc300.lc310.lc316

import com.algorithm.playground.leetcode.problems.lc300.lc310.lc316.RemoveDuplicateLetters.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicateLettersSpec extends Specification {

	@Unroll
	def "removeDuplicateLetters"() {

		expect:

			new S().removeDuplicateLetters(str) == output

		where:

			str                                              || output
			"bcabc"                                          || "abc"
			"cbacdcbc"                                       || "acdb"
			""                                               || ""
			"rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws" || "bfegkuyjorndiqszpcaw"
			"abacb"                                          || "abc"
	}

}
