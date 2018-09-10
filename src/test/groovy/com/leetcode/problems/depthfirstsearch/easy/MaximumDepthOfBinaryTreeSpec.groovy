package com.leetcode.problems.depthfirstsearch.easy

import com.leetcode.problems.depthfirstsearch.easy.MaximumDepthOfBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class MaximumDepthOfBinaryTreeSpec extends Specification {

	@Unroll
	def "maxDepth"() {

		expect:

			new S().maxDepth(node(input)) == output

		where:

			input                         || output
			[3, 9, 20, null, null, 15, 7] || 3

	}

}
