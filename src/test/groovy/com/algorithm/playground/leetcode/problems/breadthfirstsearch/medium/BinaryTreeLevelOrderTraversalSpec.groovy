package com.algorithm.playground.leetcode.problems.breadthfirstsearch.medium


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

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
