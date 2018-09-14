package com.leetcode.problems.twopointers.hard

import com.leetcode.problems.twopointers.hard.TrappingRainWater.Solution as S
import com.leetcode.problems.twopointers.hard.TrappingRainWater.TwoPointersSolution as TPS
import spock.lang.Specification
import spock.lang.Unroll

class TrappingRainWaterSpec extends Specification {

	@Unroll
	def "trap"() {

		expect:

			new S().trap(height as int[]) == output

		where:

			height                               || output
			[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] || 6
			[0, 1, 0, 2]                         || 1
			[1, 0, 2]                            || 1
			[2, 0, 2]                            || 2
			[4, 2, 3]                            || 1

	}

	@Unroll
	def "trap_tp"() {

		expect:

			new TPS().trap(height as int[]) == output

		where:

			height                               || output
			[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] || 6
			[0, 1, 0, 2]                         || 1
			[1, 0, 2]                            || 1
			[2, 0, 2]                            || 2
			[4, 2, 3]                            || 1
			[]                                   || 0

	}

}
