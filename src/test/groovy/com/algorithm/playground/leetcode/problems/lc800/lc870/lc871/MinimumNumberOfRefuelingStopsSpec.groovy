package com.algorithm.playground.leetcode.problems.lc800.lc870.lc871

import com.algorithm.playground.leetcode.problems.lc800.lc870.lc871.MinimumNumberOfRefuelingStops.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MinimumNumberOfRefuelingStopsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "minRefuelStops"() {

		expect:

			new S().minRefuelStops(target, start, stations as int[][]) == output

		where:

			target | start | stations                                 || output
			1      | 1     | []                                       || 0
			100    | 1     | [[10, 100]]                              || -1
			100    | 10    | [[10, 60], [20, 30], [30, 30], [60, 40]] || 2


	}

}
