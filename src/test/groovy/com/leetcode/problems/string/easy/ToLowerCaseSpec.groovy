package com.leetcode.problems.string.easy

import com.leetcode.problems.string.easy.ToLowerCase.Solution as S
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
