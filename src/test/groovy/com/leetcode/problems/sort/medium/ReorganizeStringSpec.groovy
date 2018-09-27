package com.leetcode.problems.sort.medium

import com.leetcode.problems.sort.medium.ReorganizeString.Solution as S
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
