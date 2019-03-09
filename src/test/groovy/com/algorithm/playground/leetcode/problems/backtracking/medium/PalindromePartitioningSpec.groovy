package com.algorithm.playground.leetcode.problems.backtracking.medium


import spock.lang.Specification
import spock.lang.Unroll

class PalindromePartitioningSpec extends Specification {

	@Unroll
	def "partition"() {

		expect:

			new PalindromePartitioning.Solution().partition(s) as Set == out as Set

		where:

			s     || out
			"aab" || [["aa", "b"],
					  ["a", "a", "b"]]
			"a"   || [["a"]]
			"fff" || [["f", "f", "f"],
					  ["f", "ff"],
					  ["ff", "f"],
					  ["fff"]]

	}

}
