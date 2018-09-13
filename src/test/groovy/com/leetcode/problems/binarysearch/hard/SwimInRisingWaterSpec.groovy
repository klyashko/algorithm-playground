package com.leetcode.problems.binarysearch.hard

import com.leetcode.problems.binarysearch.hard.SwimInRisingWater.BinarySearchSolution as BSS
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

	@Unroll
	def "swimInWater_binary_search"() {

		expect:

			new BSS().swimInWater(grid as int[][]) == output

		where:

			grid                                     || output
			[[0, 2],
			 [1, 3]]                                 || 3
			[[0, 1, 2, 3, 4],
			 [24, 23, 22, 21, 5],
			 [12, 13, 14, 15, 16],
			 [11, 17, 18, 19, 20],
			 [10, 9, 8, 7, 6]]                       || 16
			[[0, 3,],
			 [24, 5],
			 [12, 16]]                               || 16
			[[0, 4],
			 [24, 16]]                               || 16
			[[7, 34, 16, 12, 15, 0],
			 [10, 26, 4, 30, 1, 20],
			 [28, 27, 33, 35, 3, 8],
			 [29, 9, 13, 14, 11, 32],
			 [31, 21, 23, 24, 19, 18],
			 [22, 6, 17, 5, 2, 25]]                  || 26
			[[26, 99, 80, 1, 89, 86, 54, 90, 47, 87],
			 [9, 59, 61, 49, 14, 55, 77, 3, 83, 79],
			 [42, 22, 15, 5, 95, 38, 74, 12, 92, 71],
			 [58, 40, 64, 62, 24, 85, 30, 6, 96, 52],
			 [10, 70, 57, 19, 44, 27, 98, 16, 25, 65],
			 [13, 0, 76, 32, 29, 45, 28, 69, 53, 41],
			 [18, 8, 21, 67, 46, 36, 56, 50, 51, 72],
			 [39, 78, 48, 63, 68, 91, 34, 4, 11, 31],
			 [97, 23, 60, 17, 66, 37, 43, 33, 84, 35],
			 [75, 88, 82, 20, 7, 73, 2, 94, 93, 81]] || 81
	}

}
