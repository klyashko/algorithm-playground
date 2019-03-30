package com.algorithm.playground.leetcode.problems.lc700.lc780.lc785

import com.algorithm.playground.leetcode.problems.lc700.lc780.lc785.IsGraphBipartite.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class IsGraphBipartiteSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isBipartite"() {

		expect:

			new S().isBipartite(graph as int[][]) == output

		where:

			graph                                                                                                                                                                                                                                                                                                                                                            || output
			[[1, 3], [0, 2], [1, 3], [0, 2]]                                                                                                                                                                                                                                                                                                                                 || true
			[[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]]                                                                                                                                                                                                                                                                                                                           || false
			[[], [2, 4, 6], [1, 4, 8, 9], [7, 8], [1, 2, 8, 9], [6, 9], [1, 5, 7, 8, 9], [3, 6, 9], [2, 3, 4, 6, 9], [2, 4, 5, 6, 7, 8]]                                                                                                                                                                                                                                     || false
			[[2, 4], [2, 3, 4], [0, 1], [1], [0, 1], [7], [9], [5], [], [6], [12, 14], [], [10], [], [10], [19], [18], [], [16], [15], [23], [23], [], [20, 21], [], [], [27], [26], [], [], [34], [33, 34], [], [31], [30, 31], [38, 39], [37, 38, 39], [36], [35, 36], [35, 36], [43], [], [], [40], [], [49], [47, 48, 49], [46, 48, 49], [46, 47, 49], [45, 46, 47, 48]] || false

	}

}
