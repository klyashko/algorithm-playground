package com.algorithm.playground.leetcode.problems.lc800.lc870.lc872

import com.algorithm.playground.leetcode.problems.lc800.lc870.lc872.LeafSimilarTrees.Solution as S
import com.algorithm.playground.leetcode.problems.utils.TreeNode as N
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.TreeNode.node

class LeafSimilarTreesSpec extends Specification {

	@Unroll
	def "leafSimilarSuccess"() {

		expect:

			new S().leafSimilar(node(n1), node(n2))

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
