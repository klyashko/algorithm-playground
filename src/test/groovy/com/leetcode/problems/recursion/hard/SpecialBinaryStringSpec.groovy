package com.leetcode.problems.recursion.hard

import com.leetcode.problems.recursion.hard.SpecialBinaryString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SpecialBinaryStringSpec extends Specification {

	@Unroll
	def "makeLargestSpecial"() {

		expect:

			new S().makeLargestSpecial(str) == output

		where:

			str        || output
			"11011000" || "11100100"

	}

}
