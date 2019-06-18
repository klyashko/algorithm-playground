package com.algorithm.playground.leetcode.problems.lc600.lc670.lc674

import com.algorithm.playground.leetcode.problems.lc600.lc670.lc674.LongestContinuousIncreasingSubsequence.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LongestContinuousIncreasingSubsequenceSpec extends Specification {

	@Unroll
	def "findLengthOfLCIS"() {

		expect:

			new S().findLengthOfLCIS(nums as int[]) == out

		where:

			nums            || out
			[1, 3, 5, 4, 7] || 3
			[2, 2, 2, 2, 2] || 1

	}

}
