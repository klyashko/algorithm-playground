package com.algorithm.playground.leetcode.problems.lc200.lc200.lc206

import com.algorithm.playground.leetcode.problems.lc200.lc200.lc206.ReverseLinkedList.IterativeSolution as IS
import com.algorithm.playground.leetcode.problems.lc200.lc200.lc206.ReverseLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class ReverseLinkedListSpec extends Specification {

	@Unroll
	def "reverseList"() {

		expect:

			new S().reverseList(node(values)) == node(output)

		where:

			values          || output
			[1, 2, 3, 4, 5] || [5, 4, 3, 2, 1]

	}

	@Unroll
	def "reverseList_iterative"() {

		expect:

			new IS().reverseList(node(values)) == node(output)

		where:

			values          || output
			[1, 2, 3, 4, 5] || [5, 4, 3, 2, 1]

	}

}
