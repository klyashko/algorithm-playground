package com.algorithm.playground.leetcode.problems.lc0.lc20.lc23

import com.algorithm.playground.leetcode.problems.lc0.lc20.lc23.MergeKSortedLists.Solution as S
import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode.valueOf as node

class MergeKSortedListsSpec extends Specification {

	@Unroll
	def "mergeKLists"() {

		given:

			def lists = values.collect { node(it) } as ListNode[]

		expect:

			new S().mergeKLists(lists) == node(output)

		where:

			values   || output
			[[1, 4, 5],
			 [1, 3, 4],
			 [2, 6]] || [1, 1, 2, 3, 4, 4, 5, 6]
			[[]]     || []
	}

}
