package com.algorithm.playground.leetcode.problems.lc200.lc230.lc235

import com.algorithm.playground.leetcode.problems.lc200.lc230.lc235.LowestCommonAncestorOfABinarySearchTree.Solution as S
import com.algorithm.playground.leetcode.problems.utils.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

/**
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
class LowestCommonAncestorOfABinarySearchTreeSpec extends Specification {

	@Unroll
	def "lowestCommonAncestor"() {

		expect:

			new S().lowestCommonAncestor(node(root), new TreeNode(p), new TreeNode(q)).val == out

		where:

			root                                    | p | q || out
			[6, 2, 8, 0, 4, 7, 9, null, null, 3, 5] | 2 | 8 || 6
			[6, 2, 8, 0, 4, 7, 9, null, null, 3, 5] | 2 | 4 || 2
			[2, 1]                                  | 2 | 1 || 2


	}

}