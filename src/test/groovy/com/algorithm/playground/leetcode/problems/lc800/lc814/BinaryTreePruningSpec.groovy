package com.algorithm.playground.leetcode.problems.lc800.lc814

import com.algorithm.playground.leetcode.problems.lc800.lc814.BinaryTreePruning.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

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
