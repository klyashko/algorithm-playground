package com.leetcode.problems.breadthfirstsearch.medium

import com.leetcode.problems.breadthfirstsearch.medium.BinaryTreeLevelOrderTraversal.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeLevelOrderTraversalSpec extends Specification {

	@Unroll
	def "levelOrder"() {

		expect:

			new S().levelOrder(node(values)) == output

		where:

			values                        || output
			[3, 9, 20, null, null, 15, 7] || [[3],
											  [9, 20],
											  [15, 7]]
	}

}
