package com.algorithm.playground.leetcode.problems.lc900.lc968

import com.algorithm.playground.leetcode.problems.lc900.lc968.BinaryTreeCameras.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

class BinaryTreeCamerasSpec extends Specification {

	@Unroll
	def "minCameraCover"() {

		expect:

			new S().minCameraCover(node(root)) == out

		where:

			root                                       || out
			[0, 0, null, 0, 0]                         || 1
			[0, 1, null, 2, null, 3, null, null, 4]    || 2
			[0]                                        || 1
			[0, 0, null, null, 0, 0, null, null, 0, 0] || 2

	}

}
