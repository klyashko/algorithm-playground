package com.algorithm.playground.leetcode.problems.lc0.lc98


import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.node

@SuppressWarnings("GroovyPointlessBoolean")
class ValidateBinarySearchTreeSpec extends Specification {

	@Unroll
	def "isValidBST"() {

		expect:

			new ValidateBinarySearchTree.Solution().isValidBST(node(root)) == out

		where:

			root                        || out
			[2, 1, 3]                   || true
			[5, 1, 4, null, null, 3, 6] || false
			[1, 1]                      || false

	}

}
