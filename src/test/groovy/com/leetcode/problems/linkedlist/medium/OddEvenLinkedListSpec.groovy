package com.leetcode.problems.linkedlist.medium

import com.leetcode.problems.linkedlist.medium.OddEvenLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.linkedlist.ListNode.valueOf as node

class OddEvenLinkedListSpec extends Specification {

	@Unroll
	def "oddEvenList"() {

		expect:

			new S().oddEvenList(node(head)) == node(output)

		where:

			head                  || output
			[1, 2, 3, 4, 5]       || [1, 3, 5, 2, 4]
			[2, 1, 3, 5, 6, 4, 7] || [2, 3, 6, 7, 1, 5, 4]

	}

}
