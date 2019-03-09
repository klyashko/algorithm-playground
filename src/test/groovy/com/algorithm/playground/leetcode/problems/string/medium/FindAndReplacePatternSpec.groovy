package com.algorithm.playground.leetcode.problems.string.medium

import com.algorithm.playground.leetcode.problems.string.medium.FindAndReplacePattern.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FindAndReplacePatternSpec extends Specification {

	@Unroll
	def "findAndReplacePattern"() {

		expect:

			new S().findAndReplacePattern(words as String[], pattern) == output

		where:

			words                                      || pattern || output
			["abc", "deq", "mee", "aqq", "dkd", "ccc"] || "abb"   || ["mee", "aqq"]

	}

}
