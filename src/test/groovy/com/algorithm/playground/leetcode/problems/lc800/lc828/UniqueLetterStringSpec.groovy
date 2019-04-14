package com.algorithm.playground.leetcode.problems.lc800.lc828

import com.algorithm.playground.leetcode.problems.lc800.lc828.UniqueLetterString.Solution as S
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
