package com.leetcode.problems.lc400.lc450.lc452

import com.leetcode.problems.lc400.lc450.lc452.MinimumNumberOfArrowsToBurstBalloons.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumNumberOfArrowsToBurstBalloonsSpec extends Specification {

	@Unroll
	def "findMinArrowShots"() {

		expect:

			new S().findMinArrowShots(points as int[][]) == output

		where:

			points                                                                             || output
			[[10, 16], [2, 8], [1, 6], [7, 12]]                                                || 2
			[[1, 2], [3, 4], [5, 6], [7, 8]]                                                   || 4
			[[1, 2], [2, 3], [3, 4], [4, 5]]                                                   || 2
			[[3, 9], [7, 12], [3, 8], [6, 8], [9, 10], [2, 9], [0, 9], [3, 9], [0, 6], [2, 8]] || 2
			[[9, 12], [1, 10], [4, 11], [8, 12], [3, 9], [6, 9], [6, 7]]                       || 2

	}

}
