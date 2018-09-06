package com.leetcode.problems.tree.hard

import com.leetcode.problems.tree.hard.RedundantConnectionII.Solution as S
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
			[[2, 1], [3, 1], [4, 2], [1, 4]]         || [2, 1]
			[[5, 2], [5, 1], [3, 1], [3, 4], [3, 5]] || [3, 1]

	}

}
