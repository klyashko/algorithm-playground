package com.algorithm.playground.leetcode.problems.lc700.lc700.lc709

import com.algorithm.playground.leetcode.problems.lc700.lc700.lc709.ToLowerCase.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ToLowerCaseSpec extends Specification {

	@Unroll
	def "toLowerCase"() {

		expect:

			new S().toLowerCase(str) == output

		where:

			str         || output
			"Hello"     || "hello"
			"here"      || "here"
			"LOVELY"    || "lovely"
			"al&phaBET" || "al&phabet"

	}

}
