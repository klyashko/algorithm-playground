package com.algorithm.playground.leetcode.problems.lc700.lc791

import com.algorithm.playground.leetcode.problems.lc700.lc791.CustomSortString.Solution as S
import com.algorithm.playground.leetcode.problems.lc700.lc791.CustomSortString.SolutionStream as SS
import spock.lang.Specification
import spock.lang.Unroll

class CustomSortStringSpec extends Specification {

	@Unroll
	def "customSortStringStreamSolution"() {

		expect:

			new SS().customSortString(s, t) == output

		where:

			s     || t      || output
			"cba" || "abcd" || "cbad"

	}

	@Unroll
	def "customSortString"() {

		expect:

			new S().customSortString(s, t) == output

		where:

			s     || t      || output
			"cba" || "abcd" || "cbad"

	}

}
