package com.algorithm.playground.leetcode.problems.lc0.lc10.lc19

import com.algorithm.playground.leetcode.problems.lc0.lc10.lc19.RemoveNthNodeFromEndOfList.Solution as S
import com.algorithm.playground.leetcode.problems.lc0.lc10.lc19.RemoveNthNodeFromEndOfList.SolutionWithStack as SWS
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

/**
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
class RemoveNthNodeFromEndOfListSpec extends Specification {

	@Unroll
	def "removeNthFromEnd"() {

		expect:

			new S().removeNthFromEnd(node(values), n) == node(out)

		where:

			values          | n || out
			[1, 2, 3, 4, 5] | 2 || [1, 2, 3, 5]
	}

	@Unroll
	def "removeNthFromEnd solution with stack"() {

		expect:

			new SWS().removeNthFromEnd(node(values), n) == node(out)

		where:

			values          | n || out
			[1, 2, 3, 4, 5] | 2 || [1, 2, 3, 5]
	}

}