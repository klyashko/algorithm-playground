package com.leetcode.problems.lc689

import com.leetcode.problems.lc689.MaximumSumOf3NonOverlappingSubarrays.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximumSumOf3NonOverlappingSubarraysSpec extends Specification {

	@Unroll
	def "maxSumOfThreeSubarrays"() {

		expect:

			new S().maxSumOfThreeSubarrays(nums as int[], k) == out as int[]

		where:

			nums                                 | k || out
			[1, 2, 1, 2, 6, 7, 5, 1]             | 2 || [0, 3, 5]
			[7, 13, 20, 19, 19, 2, 10, 1, 1, 19] | 3 || [1, 4, 7]

	}

}
