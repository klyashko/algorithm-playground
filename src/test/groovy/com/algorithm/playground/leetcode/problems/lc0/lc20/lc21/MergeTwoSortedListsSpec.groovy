package com.algorithm.playground.leetcode.problems.lc0.lc20.lc21

import com.algorithm.playground.leetcode.problems.lc0.lc20.lc21.MergeTwoSortedLists.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class MergeTwoSortedListsSpec extends Specification {

	@Unroll
	def "mergeTwoLists"() {

		expect:

			new S().mergeTwoLists(node(values1), node(values2)) == node(output)

		where:

			values1   | values2   || output
			[1, 2, 4] | [1, 3, 4] || [1, 1, 2, 3, 4, 4]

	}

}
