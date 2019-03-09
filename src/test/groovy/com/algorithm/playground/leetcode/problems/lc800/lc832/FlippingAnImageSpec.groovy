package com.algorithm.playground.leetcode.problems.lc800.lc832


import spock.lang.Specification
import spock.lang.Unroll

class FlippingAnImageSpec extends Specification {

	@Unroll
	def "flipAndInvertImage"() {

		expect:

			output as int[][] == new Solution().flipAndInvertImage(input as int[][])

		where:

			input                                                    || output
			[[1, 1, 0], [1, 0, 1], [0, 0, 0]]                        || [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
			[[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]] || [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]

	}

}
