package com.leetcode.problems.greedy.hard

import com.leetcode.problems.greedy.hard.CreateMaximumNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CreateMaximumNumberSpec extends Specification {

	@Unroll
	def "maxNumber"() {

		expect:

			new S().maxNumber(nums1 as int[], nums2 as int[], k) == output as int[]

		where:

			nums1              | nums2              | k || output
			[3, 4, 6, 5]       | [9, 1, 2, 5, 8, 3] | 5 || [9, 8, 6, 5, 3]
			[6, 7]             | [6, 0, 4]          | 5 || [6, 7, 6, 0, 4]
			[3, 9]             | [8, 9]             | 3 || [9, 8, 9]
			[9, 1, 2, 5, 8, 3] | [3, 4, 6, 5]       | 5 || [9, 8, 6, 5, 3]

	}

}
