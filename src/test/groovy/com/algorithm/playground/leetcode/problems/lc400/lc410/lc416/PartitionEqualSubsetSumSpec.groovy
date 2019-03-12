package com.algorithm.playground.leetcode.problems.lc400.lc410.lc416

import com.algorithm.playground.leetcode.problems.lc400.lc410.lc416.PartitionEqualSubsetSum
import spock.lang.Specification
import spock.lang.Unroll

class PartitionEqualSubsetSumSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canPartition"() {

		expect:

			new PartitionEqualSubsetSum.Solution().canPartition(nums as int[]) == out

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
