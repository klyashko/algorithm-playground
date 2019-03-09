package com.algorithm.playground.leetcode.problems.divideandconquer.hard


import spock.lang.Specification
import spock.lang.Unroll

class BurstBalloonsSpec extends Specification {

	@Unroll
	def "maxCoins"() {

		expect:

			new BurstBalloons.Solution().maxCoins(nums as int[]) == output

		where:

			nums         || output
			[3, 1, 5, 8] || 167
			[]           || 0

	}

}
