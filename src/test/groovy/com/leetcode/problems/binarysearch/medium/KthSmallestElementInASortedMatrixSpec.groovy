package com.leetcode.problems.binarysearch.medium

import com.leetcode.problems.binarysearch.medium.KthSmallestElementInASortedMatrix.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KthSmallestElementInASortedMatrixSpec extends Specification {

	@Unroll
	def "kthSmallest"() {

		expect:

			new S().kthSmallest(matrix as int[][], k) == output

		where:

			matrix         | k || output
			[[1, 5, 9],
			 [10, 11, 13],
			 [12, 13, 15]] | 8 || 13

	}

}
