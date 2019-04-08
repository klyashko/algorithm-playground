package com.algorithm.playground.leetcode.problems.lc100.lc150.lc152

import spock.lang.Specification
import spock.lang.Unroll

class MaximumProductSubarraySpec extends Specification {

	@Unroll
	def "maxProduct"() {

		expect:

			new MaximumProductSubarray.Solution().maxProduct(nums as int[]) == out

		where:

			nums          || out
			[2, 3, -2, 4] || 6
			[-2, 0, -1]   || 0
			[-2, 3, -4]   || 24

	}

	@Unroll
	def "maxProduct_vector_solution"() {

		expect:

			new MaximumProductSubarray.VectorSolution().maxProduct(nums as int[]) == out

		where:

			nums          || out
			[2, 3, -2, 4] || 6
			[-2, 0, -1]   || 0
			[-2, 3, -4]   || 24

	}

}
