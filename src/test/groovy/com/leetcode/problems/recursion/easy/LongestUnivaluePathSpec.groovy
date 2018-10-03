package com.leetcode.problems.recursion.easy

import com.leetcode.problems.recursion.easy.LongestUnivaluePath.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class LongestUnivaluePathSpec extends Specification {

	@Unroll
	def "longestUnivaluePath"() {

		expect:

			new S().longestUnivaluePath(node(root)) == output

		where:

			root                     || output
			[5, 4, 5, 1, 1, null, 5] || 2
			[1, 4, 5, 4, 4, null, 5] || 2

	}

}
