package com.leetcode.problems.breadthfirstsearch.medium

import com.leetcode.problems.breadthfirstsearch.medium.BinaryTreeRightSideView.IterativeSolution as IS
import com.leetcode.problems.breadthfirstsearch.medium.BinaryTreeRightSideView.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeRightSideViewSpec extends Specification {

	@Unroll
	def "rightSideView"() {

		expect:

			new S().rightSideView(node(values)) == output

		where:

			values                      || output
			[1, 2, 3, null, 5, null, 4] || [1, 3, 4]
			[1, 2]                      || [1, 2]
			[1, 2, 3, 4]                || [1, 3, 4]

	}

	@Unroll
	def "rightSideView_iterative"() {

		expect:

			new IS().rightSideView(node(values)) == output

		where:

			values                      || output
			[1, 2, 3, null, 5, null, 4] || [1, 3, 4]
			[1, 2]                      || [1, 2]
			[1, 2, 3, 4]                || [1, 3, 4]

	}

}
