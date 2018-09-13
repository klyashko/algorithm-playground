package com.leetcode.problems.binarysearch.hard

import com.leetcode.problems.binarysearch.hard.SwimInRisingWater.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SwimInRisingWaterSpec extends Specification {

	@Unroll
	def "swimInWater"() {

		expect:

			new S().swimInWater(grid as int[][]) == output

		where:

			grid                    || output
			[[0, 2],
			 [1, 3]]                || 3
			[[0, 1, 2, 3, 4],
			 [24, 23, 22, 21, 5],
			 [12, 13, 14, 15, 16],
			 [11, 17, 18, 19, 20],
			 [10, 9, 8, 7, 6]]      || 16
			[[0, 3,],
			 [24, 5],
			 [12, 16]]              || 16
			[[0, 4],
			 [24, 16]]              || 16
			[[7, 34, 16, 12, 15, 0],
			 [10, 26, 4, 30, 1, 20],
			 [28, 27, 33, 35, 3, 8],
			 [29, 9, 13, 14, 11, 32],
			 [31, 21, 23, 24, 19, 18],
			 [22, 6, 17, 5, 2, 25]] || 26
	}

}
