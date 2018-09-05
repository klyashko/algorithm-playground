package com.leetcode.problems.tree.medium

import com.leetcode.problems.tree.medium.BinaryTreePruning.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreePruningSpec extends Specification {

	@Unroll
	def "pruneTree"() {

		expect:

			new S().pruneTree(node(input)) == node(output)

		where:

			input                    || output
			[1, null, 0, 0, 1]       || [1, null, 0, null, 1]
			[1, 0, 1, 0, 0, 0, 1]    || [1, null, 1, null, 1]
			[1, 1, 0, 1, 1, 0, 1, 0] || [1, 1, 0, 1, 1, null, 1]
	}

}
