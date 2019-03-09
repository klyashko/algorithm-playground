package com.algorithm.playground.leetcode.problems.lc300.lc392

import com.algorithm.playground.leetcode.problems.lc300.lc392.IsSubsequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class IsSubsequenceSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isSubsequence"() {

		expect:

			new S().isSubsequence(s, t) == output

		where:

			s     | t        || output
			"abc" | "ahbgdc" || true
			"axc" | "ahbgdc" || false

	}

}
