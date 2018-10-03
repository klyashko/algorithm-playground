package com.leetcode.problems.recursion.medium

import com.leetcode.problems.recursion.medium.PartitionToKEqualSumSubsets.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PartitionToKEqualSumSubsetsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canPartitionKSubsets"() {

		expect:

			new S().canPartitionKSubsets(nums as int[], k) == output

		where:

			nums                                                                                             | k  || output
			[4, 3, 2, 3, 5, 2, 1]                                                                            | 4  || true
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                 | 1  || true
			[5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3]                                                || 15 || true
			[2, 2, 10, 5, 2, 7, 2, 2, 13]                                                                    | 3  || true
			[709, 374, 1492, 1279, 2848, 6337, 365, 1923, 739, 1904, 1938, 4627, 1106, 5885, 1202]           | 4  || true
			[7628, 3147, 7137, 2578, 7742, 2746, 4264, 7704, 9532, 9679, 8963, 3223, 2133, 7792, 5911, 3979] | 6  || false

	}

}
