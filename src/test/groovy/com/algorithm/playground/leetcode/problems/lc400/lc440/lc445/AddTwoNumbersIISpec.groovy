package com.algorithm.playground.leetcode.problems.lc400.lc440.lc445

import com.algorithm.playground.leetcode.problems.lc400.lc440.lc445.AddTwoNumbersII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class AddTwoNumbersIISpec extends Specification {

	@Unroll
	def "addTwoNumbers"() {

		expect:

			new S().addTwoNumbers(node(l1), node(l2)) == node(output)

		where:

			l1           | l2        || output
			[7, 2, 4, 3] | [5, 6, 4] || [7, 8, 0, 7]
			[5]          | [5]       || [1, 0]

	}

}
