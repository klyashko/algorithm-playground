package com.algorithm.playground.leetcode.problems.lc500.lc510.lc517

import com.algorithm.playground.leetcode.problems.lc500.lc510.lc517.SuperWashingMachines.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SuperWashingMachinesSpec extends Specification {

	@Unroll
	def "findMinMoves"() {

		expect:

			new S().findMinMoves(machunes as int[]) == output

		where:

			machunes     || output
			[1, 0, 5]    || 3
			[0, 3, 0]    || 2
			[0, 2, 0]    || -1
			[4, 0, 0, 4] || 2

	}

}
