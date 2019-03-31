package com.algorithm.playground.leetcode.problems.lc300.lc378

import com.algorithm.playground.leetcode.problems.lc300.lc378.KthSmallestElementInASortedMatrix.BinarySearchSolution as BSS
import com.algorithm.playground.leetcode.problems.lc300.lc378.KthSmallestElementInASortedMatrix.Solution as S
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

	@Unroll
	def "kthSmallest_binary_search"() {

		expect:

			new BSS().kthSmallest(matrix as int[][], k) == output

		where:

			matrix         | k || output
			[[1, 5, 9],
			 [10, 11, 13],
			 [12, 13, 15]] | 8 || 13

	}

}
