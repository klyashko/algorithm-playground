package com.leetcode.problems.depthfirstsearch.medium

import com.leetcode.problems.depthfirstsearch.medium.FindBottomLeftTreeValue.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.tree.TreeNode.valueOf as node

class FindBottomLeftTreeValueSpec extends Specification {

	@Unroll
	def "findBottomLeftValue"() {

		expect:

			new S().findBottomLeftValue(node(values)) == output

		where:

			values                                                    || output
			[2, 1, 3]                                                 || 1
			[1, 2, 3, 4, null, 5, 6, null, null, null, null, 7, null] || 7
			[1]                                                       || 1

	}

}
