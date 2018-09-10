package com.leetcode.problems.hashtable.medium

import com.leetcode.problems.hashtable.medium.MostFrequentSubtreeSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

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
