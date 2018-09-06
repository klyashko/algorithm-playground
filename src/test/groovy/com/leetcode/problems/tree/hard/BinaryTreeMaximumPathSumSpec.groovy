package com.leetcode.problems.tree.hard

import com.leetcode.problems.tree.hard.BinaryTreeMaximumPathSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class BinaryTreeMaximumPathSumSpec extends Specification {

	@Unroll
	def "maxPathSum"() {

		expect:

			new S().maxPathSum(node(input)) == output

		where:

			input                           || output
			[1, 2, 3]                       || 6
			[-10, 9, 20, null, null, 15, 7] || 42
			[-3]                            || -3

	}

}
