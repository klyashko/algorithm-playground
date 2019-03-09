package com.algorithm.playground.leetcode.problems.breadthfirstsearch.medium


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeRightSideViewSpec extends Specification {

	@Unroll
	def "rightSideView"() {

		expect:

			new BinaryTreeRightSideView.Solution().rightSideView(node(values)) == output

		where:

			values                      || output
			[1, 2, 3, null, 5, null, 4] || [1, 3, 4]
			[1, 2]                      || [1, 2]
			[1, 2, 3, 4]                || [1, 3, 4]

	}

	@Unroll
	def "rightSideView_iterative"() {

		expect:

			new BinaryTreeRightSideView.IterativeSolution().rightSideView(node(values)) == output

		where:

			values                      || output
			[1, 2, 3, null, 5, null, 4] || [1, 3, 4]
			[1, 2]                      || [1, 2]
			[1, 2, 3, 4]                || [1, 3, 4]

	}

}
