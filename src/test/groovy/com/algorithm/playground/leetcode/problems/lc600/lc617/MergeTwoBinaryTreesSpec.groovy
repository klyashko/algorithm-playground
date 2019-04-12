package com.algorithm.playground.leetcode.problems.lc600.lc617

import com.algorithm.playground.leetcode.problems.lc600.lc617.MergeTwoBinaryTrees.Solution as S
import com.algorithm.playground.leetcode.problems.utils.TreeNode as N
import spock.lang.Specification
import spock.lang.Unroll

class MergeTwoBinaryTreesSpec extends Specification {

	@Unroll
	def "mergeTrees"() {

		expect:

			new S().mergeTrees(t1, t2) == output

		where:

			t1                                                       || t2                                                       || output
			new N(val: 1, left: new N(val: 3), right: new N(val: 2)) || new N(val: 2, left: new N(val: 1), right: new N(val: 3)) || new N(val: 3, left: new N(val: 4), right: new N(val: 5))

	}

}
