package com.algorithm.playground.leetcode.problems.twopointers.easy

import com.algorithm.playground.leetcode.problems.twopointers.easy.IntersectionOfTwoArrays.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class IntersectionOfTwoArraysSpec extends Specification {

	@Unroll
	def "intersection"() {

		expect:

			//noinspection GroovyAssignabilityCheck
			new S().intersection(nums1 as int[], nums2 as int[]) as Set == output as Set

		where:

			nums1        | nums2           || output
			[1, 2, 2, 1] | [2, 2]          || [2]
			[4, 9, 5]    | [9, 4, 9, 8, 4] || [9, 4]

	}

}
