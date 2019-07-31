package com.algorithm.playground.leetcode.problems.lc100.lc100.lc105


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class ConstructBinaryTreeFromPreorderAndInorderTraversalSpec extends Specification {

	@Unroll
	def "buildTree"() {

		expect:

			new ConstructBinaryTreeFromPreorderAndInorderTraversal.Solution().buildTree(pre as int[], inorder as int[]) == node(out)

		where:

			pre               | inorder           || out
			[3, 9, 20, 15, 7] | [9, 3, 15, 20, 7] || [3, 9, 20, null, null, 15, 7]
			[3, 9, 20]        | [9, 3, 20]        || [3, 9, 20]
			[1, 2, 3]         | [2, 3, 1]         || [1, 2, null, null, 3, null]

	}

}
