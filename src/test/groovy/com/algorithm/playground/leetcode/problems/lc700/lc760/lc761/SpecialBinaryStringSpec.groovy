package com.algorithm.playground.leetcode.problems.lc700.lc760.lc761

import com.algorithm.playground.leetcode.problems.lc700.lc760.lc761.SpecialBinaryString.Solution as S
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
