package com.algorithm.playground.leetcode.problems.lc100.lc130.lc131

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc131.PalindromePartitioning
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
