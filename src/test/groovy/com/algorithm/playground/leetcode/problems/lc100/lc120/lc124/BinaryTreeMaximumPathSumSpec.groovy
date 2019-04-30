package com.algorithm.playground.leetcode.problems.lc100.lc120.lc124

import com.algorithm.playground.leetcode.problems.lc100.lc120.lc124.BinaryTreeMaximumPathSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class BinaryTreeMaximumPathSumSpec extends Specification {

	@Unroll
	def "maxPathSum"() {

		expect:

			new S().maxPathSum(node(input)) == output

		where:

			input                                                              || output
			[1, 2, 3]                                                          || 6
			[-10, 9, 20, null, null, 15, 7]                                    || 42
			[-3]                                                               || -3

	}

}
