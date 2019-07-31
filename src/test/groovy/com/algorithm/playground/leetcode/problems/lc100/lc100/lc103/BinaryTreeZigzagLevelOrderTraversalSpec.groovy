package com.algorithm.playground.leetcode.problems.lc100.lc100.lc103

import com.algorithm.playground.leetcode.problems.lc100.lc100.lc103.BinaryTreeZigzagLevelOrderTraversal.Solution as S
import com.algorithm.playground.leetcode.problems.lc100.lc100.lc103.BinaryTreeZigzagLevelOrderTraversal.SolutionRecursive as SR
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
class BinaryTreeZigzagLevelOrderTraversalSpec extends Specification {

	@Unroll
	def "zigzagLevelOrder"() {

		expect:

			new S().zigzagLevelOrder(node(root)) == out

		where:

			root                          || out
			[3, 9, 20, null, null, 15, 7] || [[3],
											  [20, 9],
											  [15, 7]]

	}

	@Unroll
	def "zigzagLevelOrder recursive"() {

		expect:

			new SR().zigzagLevelOrder(node(root)) == out

		where:

			root                          || out
			[3, 9, 20, null, null, 15, 7] || [[3],
											  [20, 9],
											  [15, 7]]

	}

}