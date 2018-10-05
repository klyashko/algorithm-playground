package com.leetcode.problems.reservoirsampling.medium

import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.linkedlist.ListNode.valueOf as node
import static com.leetcode.problems.reservoirsampling.medium.LinkedListRandomNode.solution

class LinkedListRandomNodeSpec extends Specification {

	@Unroll
	def "getRandom"() {

		given:

			def s = solution(node(values))


		expect:

			n.times {
				def i = s.getRandom()
				println(i)
				assert i in values
			}

		where:

			values    || n
			[1, 2, 3] || 6

	}

}
