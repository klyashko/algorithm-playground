package com.algorithm.playground.leetcode.problems.lc800.lc841

import spock.lang.Specification
import spock.lang.Unroll

class KeysAndRoomsSpec extends Specification {

	@Unroll
	def "canVisitAllRooms"() {

		expect:

			new KeysAndRooms.Solution().canVisitAllRooms(rooms) == output

		where:

			rooms                         || output
			[[1], [2], [3], []]           || true
			[[1, 3], [3, 0, 1], [2], [0]] || false

	}

	@Unroll
	def "canVisitAllRooms_iterative"() {

		expect:

			new KeysAndRooms.IterativeSolution().canVisitAllRooms(rooms) == output

		where:

			rooms                         || output
			[[1], [2], [3], []]           || true
			[[1, 3], [3, 0, 1], [2], [0]] || false

	}

}
