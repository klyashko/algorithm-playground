package com.algorithm.playground.leetcode.problems.sort.medium

import com.algorithm.playground.leetcode.problems.sort.medium.SortList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.ListNode.valueOf as node

class SortListSpec extends Specification {

	@Unroll
	def "sortList"() {

		expect:

			new S().sortList(node(head)) == node(output)

		where:

			head             || output
			[4, 2, 1, 3]     || [1, 2, 3, 4]
			[-1, 5, 3, 4, 0] || [-1, 0, 3, 4, 5]

	}

}
