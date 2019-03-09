package com.algorithm.playground.leetcode.problems.lc700.lc741

import com.algorithm.playground.leetcode.problems.lc700.lc741.CherryPickup
import spock.lang.Specification
import spock.lang.Unroll

class CherryPickupSpec extends Specification {

	@Unroll
	def "cherryPickup"() {

		expect:

			new CherryPickup.Solution().cherryPickup(input as int[][]) == output

		where:

			input                                                                                                                                                             || output
			[[0, 1, -1], [1, 0, -1], [1, 1, 1]]                                                                                                                               || 5
			[[1, 1, -1], [1, -1, 1], [-1, 1, 1]]                                                                                                                              || 0
			[[1, 1, 1, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 1, 1, 1]] || 15
			[[1, -1, -1, -1, -1], [1, 0, 1, -1, -1], [0, -1, 1, 0, 1], [1, 0, 1, 1, 0], [-1, -1, -1, 1, 1]]                                                                   || 10

	}

}
