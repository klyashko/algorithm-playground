package com.leetcode.problems.breadthfirstsearch.easy

import com.leetcode.problems.breadthfirstsearch.easy.SymmetricTree.IterativeSolution as IS
import com.leetcode.problems.breadthfirstsearch.easy.SymmetricTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class SymmetricTreeSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isSymmetric"() {

		expect:

			new S().isSymmetric(node(values)) == output

		where:

			values                      || output
			[1, 2, 2, 3, 4, 4, 3]       || true
			[1, 2, 2, null, 3, null, 3] || false
			[1, 2, 3]                   || false

	}

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isSymmetric_iterative"() {

		expect:

			new IS().isSymmetric(node(values)) == output

		where:

			values                      || output
			[1, 2, 2, 3, 4, 4, 3]       || true
			[1, 2, 2, null, 3, null, 3] || false
			[1, 2, 3]                   || false

	}

}
