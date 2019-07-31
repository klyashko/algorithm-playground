package com.algorithm.playground.leetcode.problems.lc100.lc140.lc142

import com.algorithm.playground.leetcode.problems.lc100.lc140.lc142.LinkedListCycleII.Solution as S
import com.algorithm.playground.leetcode.problems.lc100.lc140.lc142.LinkedListCycleII.SolutionWithAdditionalMemory as SWAM
import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

/**
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 */
class LinkedListCycleIISpec extends Specification {

	@Unroll
	def "detectCycle"() {

		given:

			def head = node(list)
			if (out) {
				cycleList(head, out)
			}

		when:

			def n = new S().detectCycle(head)

		then:

			(!n && !out) || n.val == out

		where:

			list          || out
			[3, 2, 0, -4] || 2
			[1, 2]        || 1
			[1]           || null

	}

	@Unroll
	def "detectCycle with additional memory"() {

		given:

			def head = node(list)
			if (out) {
				cycleList(head, out)
			}

		when:

			def n = new SWAM().detectCycle(head)

		then:

			(!n && !out) || n.val == out

		where:

			list          || out
			[3, 2, 0, -4] || 2
			[1, 2]        || 1
			[1]           || null

	}

	private static cycleList(ListNode head, int val) {
		def cycleNode

		while (head.next != null) {
			if (head.val == val) {
				cycleNode = head
			}
			head = head.next
		}
		//noinspection GroovyVariableNotAssigned
		head.next = cycleNode
	}

}