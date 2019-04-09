package com.algorithm.playground.leetcode.problems.lc300.lc340.lc344

import com.algorithm.playground.leetcode.problems.lc300.lc340.lc344.ReverseString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReverseStringSpec extends Specification {

	@Unroll
	def "reverseString"() {

		expect:

			new S().reverseString(str) == output

		where:

			str                              || output
			"hello"                          || "olleh"
			"A man, a plan, a canal: Panama" || "amanaP :lanac a ,nalp a ,nam A"

	}

}
