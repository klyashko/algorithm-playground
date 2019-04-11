package com.algorithm.playground.leetcode.problems.lc500.lc559

import com.algorithm.playground.leetcode.problems.lc500.lc559.MaximumDepthOfNTree.Solution as S
import com.algorithm.playground.leetcode.problems.tree.Node as N
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
