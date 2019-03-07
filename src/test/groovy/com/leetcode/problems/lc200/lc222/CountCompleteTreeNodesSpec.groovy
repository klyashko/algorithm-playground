package com.leetcode.problems.lc200.lc222

import com.leetcode.problems.lc200.lc222.CountCompleteTreeNodes.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.node

class CountCompleteTreeNodesSpec extends Specification {

	@Unroll
	def "countNodes"() {

		expect:

			new S().countNodes(node(root)) == out

		where:

			root               || out
			[1, 2, 3, 4, 5, 6] || 6

	}

}
