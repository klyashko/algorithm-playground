package com.algorithm.playground.leetcode.problems.lc600.lc650.lc654

import com.algorithm.playground.leetcode.problems.lc600.lc650.lc654.MaximumBinaryTree.Solution as S
import com.algorithm.playground.leetcode.problems.utils.TreeNode as N
import spock.lang.Specification
import spock.lang.Unroll

class MaximumBinaryTreeSpec extends Specification {

	@Unroll
	def "constructMaximumBinaryTree"() {
		expect:

			new S().constructMaximumBinaryTree(nums as int[]) == N.valueOf(output)

		where:

			nums               || output
			[3, 2, 1, 6, 0, 5] || [6, 3, 5, null, 2, 0, null, null, null, null, 1, null, null, null, null, null]

	}

}
