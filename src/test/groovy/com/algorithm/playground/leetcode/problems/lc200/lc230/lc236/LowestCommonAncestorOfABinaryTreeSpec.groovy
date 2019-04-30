package com.algorithm.playground.leetcode.problems.lc200.lc230.lc236

import com.algorithm.playground.leetcode.problems.lc200.lc230.lc236.LowestCommonAncestorOfABinaryTree.Solution as S
import com.algorithm.playground.leetcode.problems.utils.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

/**
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
class LowestCommonAncestorOfABinaryTreeSpec extends Specification {

	@Unroll
	def "lowestCommonAncestor"() {

		expect:

			new S().lowestCommonAncestor(node(root), new TreeNode(p), new TreeNode(q)).val == out

		where:

			root                                    | p | q || out
			[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 5 | 1 || 3
			[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4] | 5 | 4 || 5

	}

}