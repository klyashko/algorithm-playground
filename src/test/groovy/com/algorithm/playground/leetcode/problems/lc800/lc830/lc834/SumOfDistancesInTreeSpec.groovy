package com.algorithm.playground.leetcode.problems.lc800.lc830.lc834

import spock.lang.Specification
import spock.lang.Unroll

class SumOfDistancesInTreeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "sumOfDistancesInTree"() {

		expect:

			new SumOfDistancesInTree.Solution().sumOfDistancesInTree(n, edges as int[][]) == output as int[]

		where:

			n | edges                                    || output
			6 | [[0, 1], [0, 2], [2, 3], [2, 4], [2, 5]] || [8, 12, 6, 10, 10, 10]
			1 | []                                       || [0]
	}

}
