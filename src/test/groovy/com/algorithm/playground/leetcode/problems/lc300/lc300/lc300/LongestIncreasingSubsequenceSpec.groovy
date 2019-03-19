package com.algorithm.playground.leetcode.problems.lc300.lc300.lc300

import com.algorithm.playground.leetcode.problems.lc300.lc300.lc300.LongestIncreasingSubsequence
import spock.lang.Specification
import spock.lang.Unroll

class LongestIncreasingSubsequenceSpec extends Specification {

	@Unroll
	def "lengthOfLIS"() {

		expect:

			new LongestIncreasingSubsequence.Solution().lengthOfLIS(nums as int[]) == out

		where:

			nums                         || out
			[10, 9, 2, 5, 3, 7, 101, 18] || 4

	}

}
