package com.leetcode.problems.depthfirstsearch.medium

import com.leetcode.problems.depthfirstsearch.medium.FindLargestValueInEachTreeRow.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class FindLargestValueInEachTreeRowSpec extends Specification {

	@Unroll
	def "largestValues"() {

		expect:

			new S().largestValues(node(values)) == output

		where:

			values                   || output
			[1, 3, 2, 5, 3, null, 9] || [1, 3, 9]

	}

}
