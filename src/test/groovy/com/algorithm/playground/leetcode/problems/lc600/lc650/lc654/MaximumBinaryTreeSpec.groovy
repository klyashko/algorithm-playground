package com.algorithm.playground.leetcode.problems.lc600.lc650.lc654

import com.algorithm.playground.leetcode.problems.lc600.lc650.lc654.MaximumBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class MaximumBinaryTreeSpec extends Specification {

	@Unroll
	def "constructMaximumBinaryTree"() {
		expect:

			new S().constructMaximumBinaryTree(nums as int[]) == node(output)

		where:

			nums               || output
			[3, 2, 1, 6, 0, 5] || [6, 3, 5, null, 2, 0, null, null, 1]

	}

}
