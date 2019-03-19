package com.algorithm.playground.leetcode.problems.lc500.lc513

import com.algorithm.playground.leetcode.problems.lc500.lc513.FindBottomLeftTreeValue
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.tree.TreeNode.valueOf as node

class FindBottomLeftTreeValueSpec extends Specification {

	@Unroll
	def "findBottomLeftValue"() {

		expect:

			new FindBottomLeftTreeValue.Solution().findBottomLeftValue(node(values)) == output

		where:

			values                                                    || output
			[2, 1, 3]                                                 || 1
			[1, 2, 3, 4, null, 5, 6, null, null, null, null, 7, null] || 7
			[1]                                                       || 1

	}

}
