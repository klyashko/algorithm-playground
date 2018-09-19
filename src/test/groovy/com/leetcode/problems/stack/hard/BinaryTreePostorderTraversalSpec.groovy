package com.leetcode.problems.stack.hard

import com.leetcode.problems.stack.hard.BinaryTreePostorderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreePostorderTraversalSpec extends Specification {

	@Unroll
	def "postorderTraversal"() {

		expect:

			new S().postorderTraversal(node(values)) == output

		where:

			values                      || output
			[1, null, 2, null, null, 3] || [3, 2, 1]
			[]                          || []
			[3, 1, 2]                   || [1, 2, 3]

	}

}
