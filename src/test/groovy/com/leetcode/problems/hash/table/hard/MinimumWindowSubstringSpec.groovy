package com.leetcode.problems.hash.table.hard

import com.leetcode.problems.hash.table.hard.MinimumWindowSubstring.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumWindowSubstringSpec extends Specification {

	@Unroll
	def "minWindow"() {

		expect:

			new S().minWindow(s, t) == output

		where:

			s               | t     || output
			"ADOBECODEBANC" | "ABC" || "BANC"
			"a"             | "aa"  || ""
			"aa"            | "aa"  || "aa"
			"a"             | "a"   || "a"

	}

}
