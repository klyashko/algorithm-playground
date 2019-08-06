package com.algorithm.playground.leetcode.problems.lc100.lc140.lc141

import com.algorithm.playground.leetcode.problems.lc100.lc140.lc141.LinkedListCycle.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

/**
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
class LinkedListCycleSpec extends Specification {

	@Unroll
	def "hasCycle"() {

		given:

			def node = node(list)
			if (cycle != -1) {

				def tail = node
				while (tail.next) {
					tail = tail.next
				}

				def tmp = node

				for (int i = 0; i < cycle; i++) {
					tmp = tmp.next
				}

				tail.next = tmp
			}

		expect:

			new S().hasCycle(node) == out

		where:

			list   | cycle || out
			[1, 2] | 0     || true
			[1]    | 1     || false

	}

}