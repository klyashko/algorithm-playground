package com.leetcode.problems.stack.hard

import com.leetcode.problems.stack.hard.RemoveDuplicateLetters.Solution as S
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
