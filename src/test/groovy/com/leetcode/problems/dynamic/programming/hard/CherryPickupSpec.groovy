package com.leetcode.problems.dynamic.programming.hard

import com.leetcode.problems.dynamic.programming.hard.CherryPickup.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CherryPickupSpec extends Specification {

	@Unroll
	def "cherryPickup"() {

		expect:

			new S().cherryPickup(input as int[][]) == output

		where:

			input                                                                                                                                                             || output
			[[0, 1, -1], [1, 0, -1], [1, 1, 1]]                                                                                                                               || 5
			[[1, 1, -1], [1, -1, 1], [-1, 1, 1]]                                                                                                                              || 0
			[[1, 1, 1, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 1], [1, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 1, 1, 1]] || 15
			[[1, -1, -1, -1, -1], [1, 0, 1, -1, -1], [0, -1, 1, 0, 1], [1, 0, 1, 1, 0], [-1, -1, -1, 1, 1]]                                                                   || 10

	}

}
