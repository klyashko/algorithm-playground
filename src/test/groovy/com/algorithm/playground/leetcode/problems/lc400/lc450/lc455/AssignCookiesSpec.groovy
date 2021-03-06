package com.algorithm.playground.leetcode.problems.lc400.lc450.lc455

import com.algorithm.playground.leetcode.problems.lc400.lc450.lc455.AssignCookies.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class AssignCookiesSpec extends Specification {

	@Unroll
	def "findContentChildren"() {

		expect:

			new S().findContentChildren(g as int[], s as int[]) == output

		where:

			g             | s            || output
			[1, 2, 3]     | [1, 1]       || 1
			[1, 2]        | [1, 2, 3]    || 2
			[10, 9, 8, 7] | [5, 6, 7, 8] || 2

	}

}
