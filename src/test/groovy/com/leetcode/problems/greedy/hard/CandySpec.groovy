package com.leetcode.problems.greedy.hard

import com.leetcode.problems.greedy.hard.Candy.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CandySpec extends Specification {

	@Unroll
	def "candy"() {

		expect:
			new S().candy(ratings as int[]) == output

		where:

			ratings                || output
			[1, 0, 2]              || 5
			[1, 2, 2]              || 4
			[1, 3, 2, 2, 1]        || 7
			[1, 6, 10, 8, 7, 3, 2] || 18
			[1, 3, 4, 5, 2]        || 11

	}

}
