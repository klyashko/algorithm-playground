package com.algorithm.playground.leetcode.problems.lc0.lc40.lc42

import com.algorithm.playground.leetcode.problems.lc0.lc40.lc42.TrappingRainWater.Solution as S
import com.algorithm.playground.leetcode.problems.lc0.lc40.lc42.TrappingRainWater.TwoPointersSolution as TPS
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
