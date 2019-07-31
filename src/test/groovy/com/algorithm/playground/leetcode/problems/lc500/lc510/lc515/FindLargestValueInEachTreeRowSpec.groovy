package com.algorithm.playground.leetcode.problems.lc500.lc510.lc515

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class FindLargestValueInEachTreeRowSpec extends Specification {

	@Unroll
	def "largestValues"() {

		expect:

			new FindLargestValueInEachTreeRow.Solution().largestValues(node(values)) == output

		where:

			values                   || output
			[1, 3, 2, 5, 3, null, 9] || [1, 3, 9]

	}

}
