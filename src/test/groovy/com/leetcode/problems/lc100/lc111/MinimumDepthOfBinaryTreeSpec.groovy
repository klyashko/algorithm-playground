package com.leetcode.problems.lc100.lc111

import com.leetcode.problems.lc100.lc111.MinimumDepthOfBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.node

class MinimumDepthOfBinaryTreeSpec extends Specification {

	@Unroll
	def "minDepth"() {

		expect:

			new S().minDepth(node(tree)) == out

		where:

			tree                          || out
			[3, 9, 20, null, null, 15, 7] || 2
			[1, 2]                        || 2

	}

}
