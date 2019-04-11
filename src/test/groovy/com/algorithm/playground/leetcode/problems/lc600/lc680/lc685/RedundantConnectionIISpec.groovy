package com.algorithm.playground.leetcode.problems.lc600.lc680.lc685

import com.algorithm.playground.leetcode.problems.lc600.lc680.lc685.RedundantConnectionII.Solution as S
import com.algorithm.playground.leetcode.problems.lc600.lc680.lc685.RedundantConnectionII.SolutionFast as SF
import spock.lang.Specification
import spock.lang.Unroll

class RedundantConnectionIISpec extends Specification {

	@Unroll
	def "findRedundantDirectedConnection"() {

		expect:

			new S().findRedundantDirectedConnection(edges as int[][]) == output as int[]

		where:

			edges                                    || output
			[[1, 2], [1, 3], [2, 3]]                 || [2, 3]
			[[1, 2], [2, 3], [3, 4], [4, 1], [1, 5]] || [4, 1]
			[[2, 1], [2, 3], [3, 4], [4, 2], [1, 5]] || [4, 2]
			[[2, 1], [3, 1], [4, 2], [1, 4]]         || [2, 1]
			[[5, 2], [5, 1], [3, 1], [3, 4], [3, 5]] || [3, 1]

	}

	@Unroll
	def "findRedundantDirectedConnectionFast"() {

		expect:

			new SF().findRedundantDirectedConnection(edges as int[][]) == output as int[]

		where:

			edges                                    || output
			[[1, 2], [1, 3], [2, 3]]                 || [2, 3]
			[[1, 2], [2, 3], [3, 4], [4, 1], [1, 5]] || [4, 1]
			[[2, 1], [2, 3], [3, 4], [4, 2], [1, 5]] || [4, 2]
			[[2, 1], [3, 1], [4, 2], [1, 4]]         || [2, 1]
			[[5, 2], [5, 1], [3, 1], [3, 4], [3, 5]] || [3, 1]

	}

}
