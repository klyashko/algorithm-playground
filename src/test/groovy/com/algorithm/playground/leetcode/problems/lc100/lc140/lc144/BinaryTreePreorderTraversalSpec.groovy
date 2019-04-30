package com.algorithm.playground.leetcode.problems.lc100.lc140.lc144

import com.algorithm.playground.leetcode.problems.lc100.lc140.lc144.BinaryTreePreorderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class BinaryTreePreorderTraversalSpec extends Specification {

	@Unroll
	def "preorderTraversal"() {

		expect:

			new S().preorderTraversal(node(values)) == output

		where:

			values          || output
			[1, null, 2, 3] || [1, 2, 3]

	}

}
