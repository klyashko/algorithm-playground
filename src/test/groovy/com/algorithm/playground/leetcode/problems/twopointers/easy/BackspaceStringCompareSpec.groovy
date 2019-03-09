package com.algorithm.playground.leetcode.problems.twopointers.easy

import com.algorithm.playground.leetcode.problems.twopointers.easy.BackspaceStringCompare.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BackspaceStringCompareSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "backspaceCompare"() {

		expect:

			new S().backspaceCompare(Str, T) == output

		where:

			Str    | T      || output
			"ab#c" | "ad#c" || true
			"ab##" | "c#d#" || true
			"a##c" | "#a#c" || true
			"a#c"  | "b"    || false

	}

}
