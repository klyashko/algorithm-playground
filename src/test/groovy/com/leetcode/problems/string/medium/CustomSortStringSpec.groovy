package com.leetcode.problems.string.medium

import com.leetcode.problems.string.medium.CustomSortString.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CustomSortStringSpec extends Specification {

	@Unroll
	def "customSortString"() {

		expect:

			new S().customSortString(s, t) == output

		where:

			s     || t      || output
			"cba" || "abcd" || "cbad"

	}

}
