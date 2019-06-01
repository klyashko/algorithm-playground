package com.algorithm.playground.leetcode.problems.lc900.lc975

import com.algorithm.playground.leetcode.problems.lc900.lc975.OddEvenJump.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class OddEvenJumpSpec extends Specification {

	@Unroll
	def "oddEvenJumps"() {

		expect:

			new S().oddEvenJumps(A as int[]) == out

		where:

			A                        || out
			[10, 13, 12, 14, 15]     || 2
			[2, 3, 1, 1, 4]          || 3
			[5, 1, 3, 4, 2]          || 3
			[1, 2, 3, 2, 1, 4, 4, 5] || 6

	}

}
