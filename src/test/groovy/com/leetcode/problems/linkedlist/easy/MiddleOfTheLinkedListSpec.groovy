package com.leetcode.problems.linkedlist.easy

import com.leetcode.problems.linkedlist.easy.MiddleOfTheLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.linkedlist.easy.ListNode.valueOf as node

class MiddleOfTheLinkedListSpec extends Specification {

	@Unroll
	def "middleNode"() {

		given:

			def head = node(values)
			def mid = head
			while (mid.val != middle) {
				mid = mid.next
			}

		expect:

			new S().middleNode(head) == mid

		where:

			values             || middle
			[1, 2, 3, 4, 5]    || 3
			[1, 2, 3, 4, 5, 6] || 4

	}

}
