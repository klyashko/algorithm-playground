package com.algorithm.playground.leetcode.problems.linkedlist.hard

import com.algorithm.playground.leetcode.problems.linkedlist.hard.ReverseNodesInKGroup.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.linkedlist.ListNode.valueOf as node

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
