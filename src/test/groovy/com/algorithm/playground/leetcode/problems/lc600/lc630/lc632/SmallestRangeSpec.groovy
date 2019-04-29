package com.algorithm.playground.leetcode.problems.lc600.lc630.lc632

import com.algorithm.playground.leetcode.problems.lc600.lc630.lc632.SmallestRange.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SmallestRangeSpec extends Specification {

	@Unroll
	def "smallestRange"() {

		expect:

			new S().smallestRange(nums) == output as int[]

		where:

			nums               || output
			[[4, 10, 15, 24, 26],
			 [0, 9, 12, 20],
			 [5, 18, 22, 30]]  || [20, 24]
			[[1, 2, 3],
			 [1, 2, 3],
			 [1, 2, 3]]        || [1, 1]
			[[1, 3, 5, 7, 9],
			 [2, 4, 6, 8, 10]] || [1, 2]
			[[-5, -4, -3, -2, -1],
			 [1, 2, 3, 4, 5]]  || [-1, 1]

	}

}
