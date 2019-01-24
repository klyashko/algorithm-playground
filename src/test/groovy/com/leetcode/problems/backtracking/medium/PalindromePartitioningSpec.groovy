package com.leetcode.problems.backtracking.medium

import com.leetcode.problems.backtracking.medium.PalindromePartitioning.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PalindromePartitioningSpec extends Specification {

	@Unroll
	def "partition"() {

		expect:

			new S().partition(s) as Set == out as Set

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
