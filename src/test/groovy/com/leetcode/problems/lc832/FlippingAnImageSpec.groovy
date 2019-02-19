package com.leetcode.problems.lc832

import com.leetcode.problems.lc832.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FlippingAnImageSpec extends Specification {

	@Unroll
	def "flipAndInvertImage"() {

		expect:

			output as int[][] == new S().flipAndInvertImage(input as int[][])

		where:

			input                                                    || output
			[[1, 1, 0], [1, 0, 1], [0, 0, 0]]                        || [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
			[[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]] || [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]

	}

}
