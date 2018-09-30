package com.leetcode.problems.divideandconquer.hard

import com.leetcode.problems.divideandconquer.hard.BurstBalloons.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BurstBalloonsSpec extends Specification {

	@Unroll
	def "maxCoins"() {

		expect:

			new S().maxCoins(nums as int[]) == output

		where:

			nums         || output
			[3, 1, 5, 8] || 167
			[]           || 0

	}

}
