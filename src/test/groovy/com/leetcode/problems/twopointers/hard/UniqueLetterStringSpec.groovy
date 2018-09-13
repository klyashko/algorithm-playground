package com.leetcode.problems.twopointers.hard

import com.leetcode.problems.twopointers.hard.UniqueLetterString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class UniqueLetterStringSpec extends Specification {

	@Unroll
	def "uniqueLetterString"() {

		expect:

			new S().uniqueLetterString(str) == output

		where:

			str   || output
			"ABC" || 10
			"ABA" || 8

	}

}
