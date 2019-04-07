package com.algorithm.playground.leetcode.problems.lc100.lc100.lc107

import com.algorithm.playground.leetcode.problems.lc100.lc100.lc107.BinaryTreeLevelOrderTraversalII
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeLevelOrderTraversalIISpec extends Specification {

	@Unroll
	def "levelOrderBottom"() {

		expect:

			new BinaryTreeLevelOrderTraversalII.Solution().levelOrderBottom(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[15, 7],
											  [9, 20],
											  [3]]
			[]                            || []

	}

	@Unroll
	def "levelOrderBottom_iterative"() {

		expect:

			new BinaryTreeLevelOrderTraversalII.IterativeSolution().levelOrderBottom(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[15, 7],
											  [9, 20],
											  [3]]
			[]                            || []

	}

}
