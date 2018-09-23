package com.leetcode.problems.greedy.hard

import com.leetcode.problems.greedy.hard.CouplesHoldingHands.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CouplesHoldingHandsSpec extends Specification {

	@Unroll
	def "minSwapsCouples"() {

		expect:

			new S().minSwapsCouples(row as int[]) == output

		where:

			row          || output
			[0, 2, 1, 3] || 1
			[3, 2, 0, 1] || 0

	}

}
