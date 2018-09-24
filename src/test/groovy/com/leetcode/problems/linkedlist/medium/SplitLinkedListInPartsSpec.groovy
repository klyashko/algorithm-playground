package com.leetcode.problems.linkedlist.medium

import com.leetcode.problems.linkedlist.ListNode
import com.leetcode.problems.linkedlist.medium.SplitLinkedListInParts.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.linkedlist.ListNode.valueOf as node

class SplitLinkedListInPartsSpec extends Specification {

	@Unroll
	def "splitListToParts"() {

		given:

			def result = output.collect { node(it) } as ListNode[]

		expect:

			new S().splitListToParts(node(root), k) == result

		where:

			root                            | k || output
			[1, 2, 3]                       | 5 || [[1], [2], [3], [], []]
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 3 || [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]

	}

}
