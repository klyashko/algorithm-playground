package com.algorithm.playground.leetcode.problems.lc100.lc110.lc112


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class PathSumSpec extends Specification {

	@Unroll
	def "hasPathSum"() {

		expect:

			new PathSum.Solution().hasPathSum(node(root), sum) == out

		where:

			root                                                  | sum || out
			[5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1] | 22  || true

	}

}
