package com.algorithm.playground.leetcode.problems.lc200.lc210.lc215

import com.algorithm.playground.leetcode.problems.lc200.lc210.lc215.KthLargestElementInAnArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KthLargestElementInAnArraySpec extends Specification {

	@Unroll
	def "findKthLargest"() {

		expect:

			new S().findKthLargest(nums as int[], k) == output

		where:

			nums                        | k || output
			[3, 2, 1, 5, 6, 4]          | 2 || 5
			[3, 2, 3, 1, 2, 4, 5, 5, 6] | 4 || 4

	}

}
