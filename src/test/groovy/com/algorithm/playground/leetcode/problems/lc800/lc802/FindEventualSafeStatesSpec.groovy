package com.algorithm.playground.leetcode.problems.lc800.lc802

import com.algorithm.playground.leetcode.problems.lc800.lc802.FindEventualSafeStates.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FindEventualSafeStatesSpec extends Specification {

	@Unroll
	def "eventualSafeNodes"() {

		expect:

			new S().eventualSafeNodes(graph as int[][]) == output

		where:

			graph                                   || output
			[[1, 2], [2, 3], [5], [0], [5], [], []] || [2, 4, 5, 6]
			[[], [0, 2, 3, 4], [3], [4], []]        || [0, 1, 2, 3, 4]

	}

}
