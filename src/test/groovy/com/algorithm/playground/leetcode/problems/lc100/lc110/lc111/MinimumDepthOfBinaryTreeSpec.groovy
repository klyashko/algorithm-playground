package com.algorithm.playground.leetcode.problems.lc100.lc110.lc111


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class MinimumDepthOfBinaryTreeSpec extends Specification {

	@Unroll
	def "minDepth"() {

		expect:

			new MinimumDepthOfBinaryTree.Solution().minDepth(node(tree)) == out

		where:

			tree                          || out
			[3, 9, 20, null, null, 15, 7] || 2
			[1, 2]                        || 2

	}

}
