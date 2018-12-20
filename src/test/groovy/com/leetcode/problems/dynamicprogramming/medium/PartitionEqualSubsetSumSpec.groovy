package com.leetcode.problems.dynamicprogramming.medium

import com.leetcode.problems.dynamicprogramming.medium.PartitionEqualSubsetSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PartitionEqualSubsetSumSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canPartition"() {

		expect:

			new S().canPartition(nums as int[]) == out

		where:

			nums                                                                                                                                                                                                                                                                                                           || out
			[3, 3, 3, 4, 5]                                                                                                                                                                                                                                                                                                || true
			[2, 2, 3, 5]                                                                                                                                                                                                                                                                                                   || false
			[1, 5, 11, 5]                                                                                                                                                                                                                                                                                                  || true
			[1, 2, 3, 5]                                                                                                                                                                                                                                                                                                   || false
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 100]    || false
			[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 97, 95] || true

	}

}
