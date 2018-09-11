package com.leetcode.problems.depthfirstsearch.hard

import com.leetcode.problems.depthfirstsearch.hard.SumOfDistancesInTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SumOfDistancesInTreeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "sumOfDistancesInTree"() {

		expect:

			new S().sumOfDistancesInTree(n, edges as int[][]) == output as int[]

		where:

			n | edges                                    || output
			6 | [[0, 1], [0, 2], [2, 3], [2, 4], [2, 5]] || [8, 12, 6, 10, 10, 10]
			1 | []                                       || [0]
	}

}
