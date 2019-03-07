package com.leetcode.problems.lc100.lc110.lc112

import com.leetcode.problems.lc100.lc110.lc112.PathSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.node

class PathSumSpec extends Specification {

	@Unroll
	def "hasPathSum"() {

		expect:

			new S().hasPathSum(node(root), sum) == out

		where:

			root                                                  | sum || out
			[5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1] | 22  || true

	}

}
