package com.leetcode.problems.breadthfirstsearch.hard

import com.leetcode.problems.breadthfirstsearch.hard.ShortestPathToGetAllKeys.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ShortestPathToGetAllKeysSpec extends Specification {

	@Unroll
	def "shortestPathAllKeys"() {

		expect:

			new S().shortestPathAllKeys(grid as String[]) == output

		where:

			grid      || output
			["@.a.#",
			 "###.#",
			 "b.A.B"] || 6
			["@..aA",
			 "..B#.",
			 "....b"] || 8

	}

}
