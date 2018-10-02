package com.leetcode.problems.binarysearchtree.easy

import com.leetcode.problems.binarysearchtree.easy.MinimumAbsoluteDifferenceInBST.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class MinimumAbsoluteDifferenceInBSTSpec extends Specification {

	@Unroll
	def "getMinimumDifference"() {

		expect:

			new S().getMinimumDifference(node(root)) == output

		where:

			root                        || output
			[1, null, 3, null, null, 2] || 1

	}

}
