package com.leetcode.problems.lc200.lc218

import com.leetcode.problems.lc200.lc218.TheSkylineProblem.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TheSkylineProblemSpec extends Specification {

	@Unroll
	def "getSkyline"() {

		given:

			def result = output.collect { it as int[] }

		expect:

			new S().getSkyline(buildings as int[][]) == result

		where:

			buildings                                                                                 || output
			[[15, 20, 10], [19, 24, 8]]                                                               || [[15, 10], [20, 8], [24, 0]]
			[[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]                          || [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
			[]                                                                                        || []
			[[0, 2147483647, 2147483647]]                                                             || [[0, 2147483647], [2147483647, 0]]
			[[1, 2, 1], [2147483646, 2147483647, 2147483647]]                                         || [[1, 1], [2, 0], [2147483646, 2147483647], [2147483647, 0]]
			[[0, 2, 3], [2, 5, 3]]                                                                    || [[0, 3], [5, 0]]
			[[2, 9, 10], [9, 12, 15]]                                                                 || [[2, 10], [9, 15], [12, 0]]
			[[1, 2, 1], [1, 2, 2], [1, 2, 3]]                                                         || [[1, 3], [2, 0]]
			[[0, 5, 7], [5, 10, 7], [5, 10, 12], [10, 15, 7], [15, 20, 7], [15, 20, 12], [20, 25, 7]] || [[0, 7], [5, 12], [10, 7], [15, 12], [20, 7], [25, 0]]
			[[3, 10, 20], [3, 9, 19], [3, 8, 18], [3, 7, 17], [3, 6, 16], [3, 5, 15], [3, 4, 14]]     || [[3, 20], [10, 0]]

	}

}
