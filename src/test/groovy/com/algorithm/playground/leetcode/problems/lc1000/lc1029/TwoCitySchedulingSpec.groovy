package com.algorithm.playground.leetcode.problems.lc1000.lc1029

import com.algorithm.playground.leetcode.problems.lc1000.lc1029.TwoCityScheduling.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TwoCitySchedulingSpec extends Specification {

	@Unroll
	def "twoCitySchedCost"() {

		expect:

			new S().twoCitySchedCost(costs as int[][]) == out

		where:

			costs                                                                   || out
			[[10, 20], [30, 200], [400, 50], [30, 20]]                              || 110
			[[259, 770], [448, 54], [926, 667], [184, 139], [840, 118], [577, 469]] || 1859

	}

}
