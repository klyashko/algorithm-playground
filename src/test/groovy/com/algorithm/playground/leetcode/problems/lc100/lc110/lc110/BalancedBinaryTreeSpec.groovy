package com.algorithm.playground.leetcode.problems.lc100.lc110.lc110

import com.algorithm.playground.leetcode.problems.lc100.lc110.lc110.BalancedBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.node

class BalancedBinaryTreeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isBalanced"() {

		expect:

			new S().isBalanced(node(root)) == out

		where:

			root                              || out
			[3, 9, 20, null, null, 15, 7]     || true
			[1, 2, 2, 3, 3, null, null, 4, 4] || false

	}

}
