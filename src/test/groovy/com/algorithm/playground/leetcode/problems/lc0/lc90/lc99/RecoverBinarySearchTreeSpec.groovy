package com.algorithm.playground.leetcode.problems.lc0.lc90.lc99

import com.algorithm.playground.leetcode.problems.lc0.lc90.lc99.RecoverBinarySearchTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class RecoverBinarySearchTreeSpec extends Specification {

	@Unroll
	def "recoverTree"() {

		given:

			def tree = node(root)

		when:

			new S().recoverTree(tree)

		then:

			tree == node(out)

		where:

			root                     || out
			[1, 3, null, null, 2]    || [3, 1, null, null, 2]
			[3, 1, 4, null, null, 2] || [2, 1, 4, null, null, 3]
			[2, 3, 1]                || [2, 1, 3]

	}

}
