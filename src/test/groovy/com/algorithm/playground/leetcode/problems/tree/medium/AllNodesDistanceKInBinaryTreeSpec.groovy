package com.algorithm.playground.leetcode.problems.tree.medium

import com.algorithm.playground.leetcode.problems.tree.medium.AllNodesDistanceKInBinaryTree.DFSOnlySolution as DFSS
import com.algorithm.playground.leetcode.problems.tree.medium.AllNodesDistanceKInBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class AllNodesDistanceKInBinaryTreeSpec extends Specification {

	@Unroll
	def "distanceK"() {

		expect:

			new S().distanceK(node(root), node(target), k) as Set == out as Set

		where:

			root                                    | target | k || out
			[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | [5]    | 2 || [7, 4, 1]

	}

	@Unroll
	def "distanceK_dfs_only"() {

		expect:

			new DFSS().distanceK(node(root), node(target), k) as Set == out as Set

		where:

			root                                    | target | k || out
			[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | [5]    | 2 || [7, 4, 1]

	}

}
