package com.algorithm.playground.leetcode.problems.lc700.lc780.lc783

import com.algorithm.playground.leetcode.problems.lc700.lc780.lc783.MinimumDistanceBetweenBSTNodes.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.valueOf as node

class MinimumDistanceBetweenBSTNodesSpec extends Specification {

	@Unroll
	def "minDiffInBST"() {

		expect:

			new S().minDiffInBST(node(root)) == output

		where:

			root                                         || output
			[4, 2, 6, 1, 3, null, null]                  || 1
			[90, 69, null, 49, 89, null, null, null, 52] || 1

	}

}
