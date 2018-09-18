package com.leetcode.problems.stack.medium

import com.leetcode.problems.stack.medium.BinaryTreeInorderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeInorderTraversalSpec extends Specification {

	@Unroll
	def "inorderTraversal"() {

		expect:

			new S().inorderTraversal(node(values)) == output

		where:

			values                      || output
			[1, null, 2, null, null, 3] || [1, 3, 2]

	}

}
