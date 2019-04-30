package com.algorithm.playground.leetcode.problems.lc100.lc140.lc145

import com.algorithm.playground.leetcode.problems.lc100.lc140.lc145.BinaryTreePostorderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class BinaryTreePostorderTraversalSpec extends Specification {

	@Unroll
	def "postorderTraversal"() {

		expect:

			new S().postorderTraversal(node(values)) == output

		where:

			values                   || output
			[1, null, 2, 3]          || [3, 2, 1]
			[]                       || []
			[3, 1, 2]                || [1, 2, 3]
			[3, 2, 4, null, null, 1] || [2, 1, 4, 3]

	}

}
