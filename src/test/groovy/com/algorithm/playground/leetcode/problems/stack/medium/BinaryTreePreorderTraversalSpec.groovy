package com.algorithm.playground.leetcode.problems.stack.medium

import com.algorithm.playground.leetcode.problems.stack.medium.BinaryTreePreorderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreePreorderTraversalSpec extends Specification {

	@Unroll
	def "preorderTraversal"() {

		expect:

			new S().preorderTraversal(node(values)) == output

		where:

			values                      || output
			[1, null, 2, null, null, 3] || [1, 2, 3]

	}

}
