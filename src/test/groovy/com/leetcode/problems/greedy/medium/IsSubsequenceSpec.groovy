package com.leetcode.problems.greedy.medium

import com.leetcode.problems.greedy.medium.IsSubsequence.Solution as S
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
