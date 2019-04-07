package com.algorithm.playground.leetcode.problems.lc700.lc760.lc767

import com.algorithm.playground.leetcode.problems.lc700.lc760.lc767.ReorganizeString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ReorganizeStringSpec extends Specification {

	@Unroll
	def "reorganizeString"() {

		expect:

			new S().reorganizeString(str) == output

		where:

			str    || output
			"aab"  || "aba"
			"aaab" || ""

	}

}
