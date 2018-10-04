package com.leetcode.problems.random.medium

import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.random.medium.RandomPickWithWeight.solution

class RandomPickWithWeightSpec extends Specification {

	@Unroll
	def "pickIndex"() {

		given:

			def s = solution(w as int[])

		expect:

			n.times {
				def i = s.pickIndex()
				println(i)
				assert i >= 0 && i < w.size()
			}

		where:

			w             || n
			[1]           || 5
			[1, 3]        || 10
			[3, 14, 1, 7] || 100


	}

}
