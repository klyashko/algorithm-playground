package com.leetcode.problems.array.easy

import com.leetcode.problems.array.easy.TransposeMatrix.Solution
import spock.lang.Specification

class TransposeMatrixSpec extends Specification {

	def "transpose"() {
		expect:

			output as int[][] == new Solution().transpose(input as int[][])

		where:

			input                             || output
			[[1, 2, 3], [4, 5, 6], [7, 8, 9]] || [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
			[[1, 2, 3], [4, 5, 6]]            || [[1, 4], [2, 5], [3, 6]]
	}

}
