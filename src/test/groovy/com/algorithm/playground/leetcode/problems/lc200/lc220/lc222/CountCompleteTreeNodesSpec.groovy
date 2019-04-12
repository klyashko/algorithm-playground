package com.algorithm.playground.leetcode.problems.lc200.lc220.lc222

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class CountCompleteTreeNodesSpec extends Specification {

	@Unroll
	def "countNodes"() {

		expect:

			new CountCompleteTreeNodes.Solution().countNodes(node(root)) == out

		where:

			root               || out
			[1, 2, 3, 4, 5, 6] || 6

	}

}
