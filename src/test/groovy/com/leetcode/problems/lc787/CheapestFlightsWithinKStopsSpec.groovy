package com.leetcode.problems.lc787

import com.leetcode.problems.lc787.CheapestFlightsWithinKStops.DFSSolution as DFSS
import com.leetcode.problems.lc787.CheapestFlightsWithinKStops.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CheapestFlightsWithinKStopsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "findCheapestPrice"() {

		expect:

			new S().findCheapestPrice(n, flights as int[][], src, dist, K) == out

		where:

			n | flights                                                            | src | dist | K || out
			3 | [[0, 1, 100], [1, 2, 100], [0, 2, 500]]                            | 0   | 2    | 1 || 200
			3 | [[0, 1, 100], [1, 2, 100], [0, 2, 500]]                            | 0   | 2    | 0 || 500
			5 | [[0, 1, 5], [1, 2, 5], [0, 3, 2], [3, 1, 2], [1, 4, 1], [4, 2, 1]] | 0   | 2    | 2 || 7
	}

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "findCheapestPrice_dfs"() {

		expect:

			new DFSS().findCheapestPrice(n, flights as int[][], src, dist, K) == out

		where:

			n | flights                                                            | src | dist | K || out
			3 | [[0, 1, 100], [1, 2, 100], [0, 2, 500]]                            | 0   | 2    | 1 || 200
			3 | [[0, 1, 100], [1, 2, 100], [0, 2, 500]]                            | 0   | 2    | 0 || 500
			5 | [[0, 1, 5], [1, 2, 5], [0, 3, 2], [3, 1, 2], [1, 4, 1], [4, 2, 1]] | 0   | 2    | 2 || 7
	}

}
