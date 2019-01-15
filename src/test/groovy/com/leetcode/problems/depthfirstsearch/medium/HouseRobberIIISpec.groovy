package com.leetcode.problems.depthfirstsearch.medium

import com.leetcode.problems.depthfirstsearch.medium.HouseRobberIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.node

class HouseRobberIIISpec extends Specification {

	@Unroll
	def "rob"() {

		expect:

			new S().rob(node(root)) == out

		where:

			root                        || out
			[3, 2, 3, null, 3, null, 1] || 7
			[3, 4, 5, 1, 3, null, 1]    || 9
			[4, 1, null, 2, null, 3]    || 7

	}

}
