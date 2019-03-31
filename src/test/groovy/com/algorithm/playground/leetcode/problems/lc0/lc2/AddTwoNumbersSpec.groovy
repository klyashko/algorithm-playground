package com.algorithm.playground.leetcode.problems.lc0.lc2

import com.algorithm.playground.leetcode.problems.lc0.lc2.AddTwoNumbers.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.ListNode.valueOf as node

class AddTwoNumbersSpec extends Specification {

	@Unroll
	def "addTwoNumbers"() {

		expect:

			new S().addTwoNumbers(node(l1), node(l2)) == node(out)

		where:

			l1        | l2        || out
			[2, 4, 3] | [5, 6, 4] || [7, 0, 8]
			[1, 8]    | [0]       || [1, 8]
			[5]       | [5]       || [0, 1]

	}

}
