package com.algorithm.playground.leetcode.problems.lc0.lc10.lc14

import com.algorithm.playground.leetcode.problems.lc0.lc10.lc14.LongestCommonPrefix.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestCommonPrefixSpec extends Specification {

	@Unroll
	def "longestCommonPrefix"() {

		expect:

			new S().longestCommonPrefix(strs as String[]) == out

		where:

			strs                         || out
			["flower", "flow", "flight"] || "fl"
			["dog", "racecar", "car"]    || ""
			["aa", "a"]                  || "a"

	}

}
