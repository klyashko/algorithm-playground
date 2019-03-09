package com.algorithm.playground.leetcode.problems.binarysearch.easy

import com.algorithm.playground.leetcode.problems.binarysearch.easy.IntersectionOfTwoArraysII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class IntersectionOfTwoArraysIISpec extends Specification {

	@Unroll
	def "intersect"() {

		expect:

			new S().intersect(nums1 as int[], nums2 as int[]) == output as int[]

		where:

			nums1        | nums2           || output
			[1, 2, 2, 1] | [2, 2]          || [2, 2]
			[4, 9, 5]    | [9, 4, 9, 8, 4] || [4, 9]

	}

}
