package com.leetcode.problems.tree.easy

import com.leetcode.problems.tree.easy.MaximumDepthOfNTree.Solution as S
import com.leetcode.problems.tree.easy.Node as N
import spock.lang.Specification
import spock.lang.Unroll

class MaximumDepthOfNTreeSpec extends Specification {

	@Unroll
	def "maxDepth"() {

		given:

			def root = new N(val: 1, children: [
					new N(val: 3, children: [
							new N(val: 5),
							new N(val: 6)
					]),
					new N(val: 2),
					new N(val: 3)
			])

		expect:

			new S().maxDepth(root) == 3
	}

}
