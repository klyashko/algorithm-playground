package com.leetcode.problems.dynamicprogramming.medium

import com.leetcode.problems.dynamicprogramming.medium.MaximumProductSubarray.Solution as S
import com.leetcode.problems.dynamicprogramming.medium.MaximumProductSubarray.VectorSolution as VS
import spock.lang.Specification
import spock.lang.Unroll

class MaximumProductSubarraySpec extends Specification {

	@Unroll
	def "maxProduct"() {

		expect:

			new S().maxProduct(nums as int[]) == out

		where:

			nums          || out
			[2, 3, -2, 4] || 6
			[-2, 0, -1]   || 0
			[-2, 3, -4]   || 24

	}

	@Unroll
	def "maxProduct_vector_solution"() {

		expect:

			new VS().maxProduct(nums as int[]) == out

		where:

			nums          || out
			[2, 3, -2, 4] || 6
			[-2, 0, -1]   || 0
			[-2, 3, -4]   || 24

	}

}
