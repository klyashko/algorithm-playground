package com.algorithm.playground.leetcode.problems.lc200.lc257

import com.algorithm.playground.leetcode.problems.lc200.lc257.BinaryTreePaths.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class BinaryTreePathsSpec extends Specification {

	@Unroll
	def "binaryTreePaths"() {

		expect:

			new S().binaryTreePaths(node(root)) == out

		where:

			root               || out
			[1, 2, 3, null, 5] || ["1->2->5", "1->3"]
			[1]                || ["1"]

	}

}
