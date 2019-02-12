package com.leetcode.problems.dynamicprogramming.medium

import com.leetcode.problems.dynamicprogramming.medium.LongestIncreasingSubsequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestIncreasingSubsequenceSpec extends Specification {

	@Unroll
	def "lengthOfLIS"() {

		expect:

			new S().lengthOfLIS(nums as int[]) == out

		where:

			nums                         || out
			[10, 9, 2, 5, 3, 7, 101, 18] || 4

	}

}
