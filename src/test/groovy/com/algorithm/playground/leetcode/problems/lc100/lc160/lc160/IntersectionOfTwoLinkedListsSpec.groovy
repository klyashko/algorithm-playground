package com.algorithm.playground.leetcode.problems.lc100.lc160.lc160

import com.algorithm.playground.leetcode.problems.lc100.lc160.lc160.IntersectionOfTwoLinkedLists.Solution as S
import com.algorithm.playground.leetcode.problems.lc100.lc160.lc160.IntersectionOfTwoLinkedLists.SolutionWithStack as SWS
import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

/**
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4].
 * From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 */
class IntersectionOfTwoLinkedListsSpec extends Specification {

	@Unroll
	def "getIntersectionNode"() {

		given:

			def common = node(out)
			def nodeA = node(a)
			def nodeB = node(b)
			if (common) {

				def merge = { ListNode node ->
					while (node.next) {
						node = node.next
					}
					node.next = common
				}

				merge(nodeA)
				merge(nodeB)
			}

		expect:

			new S().getIntersectionNode(nodeA, nodeB) == common

		where:

			a         | b         || out
			[4, 1]    | [5, 0, 1] || [8, 4, 5]
			[0, 9, 1] | [3]       || [2, 4]
			[2, 6, 4] | [1, 5]    || []
			[0]       | [0]       || [1]

	}

	@Unroll
	def "getIntersectionNode with stack"() {
		given:

			def common = node(out)
			def nodeA = node(a)
			def nodeB = node(b)
			if (common) {

				def merge = { ListNode node ->
					while (node.next) {
						node = node.next
					}
					node.next = common
				}

				merge(nodeA)
				merge(nodeB)
			}

		expect:

			new SWS().getIntersectionNode(nodeA, nodeB) == common

		where:

			a         | b         || out
			[4, 1]    | [5, 0, 1] || [8, 4, 5]
			[0, 9, 1] | [3]       || [2, 4]
			[2, 6, 4] | [1, 5]    || []
			[0]       | [0]       || [1]

	}

}