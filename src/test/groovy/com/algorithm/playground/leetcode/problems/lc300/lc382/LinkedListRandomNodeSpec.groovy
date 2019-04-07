package com.algorithm.playground.leetcode.problems.lc300.lc382

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc300.lc382.LinkedListRandomNode.solution
import static com.algorithm.playground.leetcode.problems.utils.ListNode.valueOf as node

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
