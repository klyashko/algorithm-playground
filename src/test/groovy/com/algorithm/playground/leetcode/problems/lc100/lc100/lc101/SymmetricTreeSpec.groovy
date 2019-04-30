package com.algorithm.playground.leetcode.problems.lc100.lc100.lc101

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class SymmetricTreeSpec extends Specification {

	@Unroll
	def "isSymmetric"() {

		expect:

			new SymmetricTree.Solution().isSymmetric(node(values)) == output

		where:

			values                      || output
			[1, 2, 2, 3, 4, 4, 3]       || true
			[1, 2, 2, null, 3, null, 3] || false
			[1, 2, 3]                   || false

	}

	@Unroll
	def "isSymmetric_iterative"() {

		expect:

			new SymmetricTree.IterativeSolution().isSymmetric(node(values)) == output

		where:

			values                      || output
			[1, 2, 2, 3, 4, 4, 3]       || true
			[1, 2, 2, null, 3, null, 3] || false
			[1, 2, 3]                   || false

	}

}
