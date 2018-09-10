package com.leetcode.problems.depthfirstsearch.medium

import com.leetcode.problems.depthfirstsearch.medium.KeysAndRooms.IterativeSolution as IS
import com.leetcode.problems.depthfirstsearch.medium.KeysAndRooms.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KeysAndRoomsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canVisitAllRooms"() {

		expect:

			new S().canVisitAllRooms(rooms) == output

		where:

			rooms                         || output
			[[1], [2], [3], []]           || true
			[[1, 3], [3, 0, 1], [2], [0]] || false

	}

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "canVisitAllRooms_iterative"() {

		expect:

			new IS().canVisitAllRooms(rooms) == output

		where:

			rooms                         || output
			[[1], [2], [3], []]           || true
			[[1, 3], [3, 0, 1], [2], [0]] || false

	}

}
