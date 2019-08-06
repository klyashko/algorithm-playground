package com.algorithm.playground.leetcode.problems.lc500.lc540.lc543

import com.algorithm.playground.leetcode.problems.lc500.lc540.lc543.DiameterOfBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them
 */
class DiameterOfBinaryTreeSpec extends Specification {

	@Unroll
	def "diameterOfBinaryTree"() {

		expect:

			new S().diameterOfBinaryTree(node(root)) == out

		where:

			root            || out
			[1, 2, 3, 4, 5] || 3

	}

}