package com.algorithm.playground.leetcode.problems.depthfirstsearch.easy


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class MaximumDepthOfBinaryTreeSpec extends Specification {

	@Unroll
	def "maxDepth"() {

		expect:

			new MaximumDepthOfBinaryTree.Solution().maxDepth(node(input)) == output

		where:

			input                         || output
			[3, 9, 20, null, null, 15, 7] || 3

	}

}
