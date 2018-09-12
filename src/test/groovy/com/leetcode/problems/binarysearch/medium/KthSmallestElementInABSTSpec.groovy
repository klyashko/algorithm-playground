package com.leetcode.problems.binarysearch.medium

import com.leetcode.problems.binarysearch.medium.KthSmallestElementInABST.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class KthSmallestElementInABSTSpec extends Specification {

	@Unroll
	def "kthSmallest"() {

		expect:

			new S().kthSmallest(node(values), k) == output

		where:

			values                  | k || output
			"3,1,4,null,2"          | 1 || 1
			"5,3,6,2,4,null,null,1" | 3 || 3

	}

}
