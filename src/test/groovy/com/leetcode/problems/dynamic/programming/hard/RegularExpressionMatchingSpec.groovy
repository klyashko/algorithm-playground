package com.leetcode.problems.dynamic.programming.hard

import com.leetcode.problems.dynamic.programming.hard.RegularExpressionMatching.Solution as S
import spock.lang.Specification

class RegularExpressionMatchingSpec extends Specification {

	@SuppressWarnings("GroovyPointlessBoolean")
	def "isMatch"() {

		expect:

			new S().isMatch(str, pattern) == output

		where:

			str           || pattern      || output
			"aa"          || "a*"         || true
			"ab"          || ".*"         || true
			"aab"         || "c*a*b*"     || true
			"mississippi" || "mis*is*p*." || false

	}

}
