package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1019

import com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1019.NextGreaterNodeInLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class NextGreaterNodeInLinkedListSpec extends Specification {

	@Unroll
	def "nextLargerNodes"() {

		expect:

			new S().nextLargerNodes(node(vals)) == out as int[]

		where:

			vals                     || out
			[2, 1, 5]                || [5, 5, 0]
			[2, 7, 4, 3, 5]          || [7, 0, 5, 5, 0]
			[1, 7, 5, 1, 9, 2, 5, 1] || [7, 9, 9, 9, 0, 5, 0, 0]

	}

}
