package com.algorithm.playground.leetcode.problems.lc0.lc20.lc25

import com.algorithm.playground.leetcode.problems.lc0.lc20.lc25.ReverseNodesInKGroup.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.ListNode.valueOf as node

class ReverseNodesInKGroupSpec extends Specification {

	@Unroll
	def "reverseKGroup"() {

		expect:

			new S().reverseKGroup(node(head), k) == node(output)

		where:

			head            | k || output
			[1, 2, 3, 4, 5] | 3 || [3, 2, 1, 4, 5]
			[]              | 2 || []
			[1, 2, 3, 4, 5] | 2 || [2, 1, 4, 3, 5]

	}

}
