package com.leetcode.problems.breadthfirstsearch.easy

import com.leetcode.problems.breadthfirstsearch.easy.BinaryTreeLevelOrderTraversalII.IterativeSolution as IS
import com.leetcode.problems.breadthfirstsearch.easy.BinaryTreeLevelOrderTraversalII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeLevelOrderTraversalIISpec extends Specification {

	@Unroll
	def "levelOrderBottom"() {

		expect:

			new S().levelOrderBottom(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[15, 7],
											  [9, 20],
											  [3]]
			[]                            || []

	}

	@Unroll
	def "levelOrderBottom_iterative"() {

		expect:

			new IS().levelOrderBottom(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[15, 7],
											  [9, 20],
											  [3]]
			[]                            || []

	}

}
