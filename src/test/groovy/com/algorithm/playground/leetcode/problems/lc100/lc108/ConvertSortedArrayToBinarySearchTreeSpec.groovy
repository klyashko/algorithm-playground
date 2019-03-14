package com.algorithm.playground.leetcode.problems.lc100.lc108

import com.algorithm.playground.leetcode.problems.lc100.lc108.ConvertSortedArrayToBinarySearchTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.node

class ConvertSortedArrayToBinarySearchTreeSpec extends Specification {

	@Unroll
	def "sortedArrayToBST"() {

		expect:

			new S().sortedArrayToBST(nums as int[]) == node(root)

		where:

			nums               || root
			[-10, -3, 0, 5, 9] || [0, -3, 9, -10, null, 5]
			[0, 1, 2, 3, 4, 5] || [3, 1, 5, 0, 2, 4]

	}

}
