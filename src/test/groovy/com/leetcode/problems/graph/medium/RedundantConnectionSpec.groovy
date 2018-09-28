package com.leetcode.problems.graph.medium

import com.leetcode.problems.graph.medium.RedundantConnection.BFS_DFS_Solution as BDS
import com.leetcode.problems.graph.medium.RedundantConnection.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RedundantConnectionSpec extends Specification {

	@Unroll
	def "findRedundantConnection"() {

		expect:

			new S().findRedundantConnection(edges as int[][]) == output as int[]

		where:

			edges                                    || output
			[[1, 2], [1, 3], [2, 3]]                 || [2, 3]
			[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]] || [1, 4]
			[[1, 2], [2, 3], [2, 4], [4, 5], [1, 5]] || [1, 5]
			[[2, 4], [3, 4], [1, 4], [2, 5], [4, 5]] || [4, 5]

	}

	@Unroll
	def "findRedundantConnection_bfs_dfs"() {

		expect:

			new BDS().findRedundantConnection(edges as int[][]) == output as int[]

		where:

			edges                                    || output
			[[1, 2], [1, 3], [2, 3]]                 || [2, 3]
			[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]] || [1, 4]
			[[1, 2], [2, 3], [2, 4], [4, 5], [1, 5]] || [1, 5]
			[[2, 4], [3, 4], [1, 4], [2, 5], [4, 5]] || [4, 5]

	}

}
