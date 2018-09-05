package com.leetcode.problems.tree.medium

import com.leetcode.problems.tree.TreeNode as N
import com.leetcode.problems.tree.medium.MaximumBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximumBinaryTreeSpec extends Specification {

	@Unroll
	def "constructMaximumBinaryTree"() {
		expect:

			new S().constructMaximumBinaryTree(nums as int[]) == N.valueOf(output)

		where:

			nums               || output
			[3, 2, 1, 6, 0, 5] || [6, 3, 5, null, 2, 0, null, null, null, null, 1, null, null, null, null, null]

	}

}
