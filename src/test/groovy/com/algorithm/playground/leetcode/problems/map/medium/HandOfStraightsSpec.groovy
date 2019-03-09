package com.algorithm.playground.leetcode.problems.map.medium

import com.algorithm.playground.leetcode.problems.map.medium.HandOfStraights.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class HandOfStraightsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isNStraightHand"() {

		expect:

			new S().isNStraightHand(hand as int[], n) == output

		where:

			hand                        | n || output
			[1, 2, 3, 6, 2, 3, 4, 7, 8] | 3 || true
			[1, 2, 3, 4, 5]             | 4 || false
			[2, 1]                      | 2 || true
			[5, 1]                      | 2 || false
			[1, 1, 2, 2, 3, 3]          | 2 || false
	}

}
