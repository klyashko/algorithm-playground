package com.algorithm.playground.leetcode.problems.tree.easy

import com.algorithm.playground.leetcode.problems.tree.TreeNode as N
import com.algorithm.playground.leetcode.problems.tree.easy.LeafSimilarTrees.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LeafSimilarTreesSpec extends Specification {

	@Unroll
	def "leafSimilarSuccess"() {

		expect:

			new S().leafSimilar(N.valueOf(n1 as Integer[]), N.valueOf(n2 as Integer[]))


		where:

			n1                                      || n2
			[3, 5, 1, 6]                            || [3, 5, 1, 6]
			[3, 5, 1, 6, 2, 9, 8, null, null, 7, 4] || [3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8]

	}

	@Unroll
	def "leafSimilarFail"() {

		given:

			def n1 = new N(val: 3, left: new N(val: 5, left: new N(val: 6)), right: new N(val: 1))
			def n2 = new N(val: 3, left: new N(val: 5), right: new N(val: 1))

		expect:

			!new S().leafSimilar(n1, n2)

	}

}
