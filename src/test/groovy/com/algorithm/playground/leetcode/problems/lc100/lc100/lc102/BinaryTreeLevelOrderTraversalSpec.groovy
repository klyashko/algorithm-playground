package com.algorithm.playground.leetcode.problems.lc100.lc100.lc102


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class BinaryTreeLevelOrderTraversalSpec extends Specification {

	@Unroll
	def "levelOrder"() {

		expect:

			new BinaryTreeLevelOrderTraversal.Solution().levelOrder(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[3],
											  [9, 20],
											  [15, 7]]
	}

	@Unroll
	def "levelOrder_iterative"() {

		expect:

			new BinaryTreeLevelOrderTraversal.IterativeSolution().levelOrder(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[3],
											  [9, 20],
											  [15, 7]]
	}

}
