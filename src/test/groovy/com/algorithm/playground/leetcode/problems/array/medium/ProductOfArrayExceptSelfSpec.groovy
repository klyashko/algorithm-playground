package com.algorithm.playground.leetcode.problems.array.medium

import com.algorithm.playground.leetcode.problems.array.medium.ProductOfArrayExceptSelf.Solution
import spock.lang.Specification
import spock.lang.Unroll

class ProductOfArrayExceptSelfSpec extends Specification {

	@Unroll
	def "productExceptSelf"() {
		expect:

			new Solution().productExceptSelf([1, 2, 3, 4] as int[]) == [24, 12, 8, 6] as int[]

		where:

			input        || output
			[1, 2, 3, 4] || [24, 12, 8, 6]
			[0, 0]       || [0, 0]
			[1, 0, 3, 4] || [0, 12, 0, 0]
			[1, 0, 0, 4] || [0, 0, 0, 0]
	}

}
