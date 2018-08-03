package com.leetcode.problems.array.easy

import com.leetcode.problems.array.easy.FlippingAnImage.Solution
import spock.lang.Specification
import spock.lang.Unroll

class FlippingAnImageSpec extends Specification {

	@Unroll
	def "flipAndInvertImage"() {

		expect:

			new Solution().flipAndInvertImage((int[][]) input) == (int[][]) output

		where:

			input                                                    | output
			[[1, 1, 0], [1, 0, 1], [0, 0, 0]]                        | [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
			[[1, 1, 0, 0], [1, 0, 0, 1], [0, 1, 1, 1], [1, 0, 1, 0]] | [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]

	}

}
