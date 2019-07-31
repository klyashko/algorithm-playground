package com.algorithm.playground.leetcode.problems.lc500.lc500.lc508

import com.algorithm.playground.leetcode.problems.lc500.lc500.lc508.MostFrequentSubtreeSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class MostFrequentSubtreeSumSpec extends Specification {

	@Unroll
	def "findFrequentTreeSum"() {

		expect:

			new S().findFrequentTreeSum(node(input)) == output as int[]

		where:

			input      || output
			[5, 2, -3] || [2, -3, 4]
			[5, 2, -5] || [2]
			[]         || []

	}

}
