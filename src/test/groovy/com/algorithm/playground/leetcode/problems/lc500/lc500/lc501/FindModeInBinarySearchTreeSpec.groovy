package com.algorithm.playground.leetcode.problems.lc500.lc500.lc501

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.node

class FindModeInBinarySearchTreeSpec extends Specification {

	@Unroll
	def "findMode"() {

		expect:

			new FindModeInBinarySearchTree.Solution().findMode(node(root)) as Set<Integer> == out as Set

		where:

			root            || out
			[1, null, 2, 2] || [2]
			[-2147483648]   || [-2147483648]
			[-2, -2, -2]    || [-2]

	}

}
