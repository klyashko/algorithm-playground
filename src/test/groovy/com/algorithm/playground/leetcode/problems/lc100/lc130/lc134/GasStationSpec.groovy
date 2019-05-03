package com.algorithm.playground.leetcode.problems.lc100.lc130.lc134

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc134.GasStation.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class GasStationSpec extends Specification {

	@Unroll
	def "canCompleteCircuit"() {

		expect:

			new S().canCompleteCircuit(gas as int[], costs as int[]) == out

		where:

			gas              | costs           || out
			[1, 2, 3, 4, 5] || [3, 4, 5, 1, 2] || 3
			[2, 3, 4]        | [3, 4, 3]       || -1
			[5, 8, 2, 8]     | [6, 5, 6, 6]    || 3

	}

}
