package com.algorithm.playground.leetcode.problems.lc0.lc76

import com.algorithm.playground.leetcode.problems.lc0.lc76.MinimumWindowSubstring.Solution as S
import com.algorithm.playground.leetcode.problems.lc0.lc76.MinimumWindowSubstring.SolutionOptimized as SO
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

	@Unroll
	def "minWindow_opt"() {

		expect:

			new SO().minWindow(s, t) == output

		where:

			s               | t     || output
			"ADOBECODEBANC" | "ABC" || "BANC"
			"a"             | "aa"  || ""
			"aa"            | "aa"  || "aa"
			"a"             | "a"   || "a"

	}

}
