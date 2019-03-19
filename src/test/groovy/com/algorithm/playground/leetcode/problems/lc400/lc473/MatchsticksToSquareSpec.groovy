package com.algorithm.playground.leetcode.problems.lc400.lc473

import com.algorithm.playground.leetcode.problems.lc400.lc473.MatchsticksToSquare.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MatchsticksToSquareSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "makesquare"() {

		expect:

			new S().makesquare(nums as int[]) == out

		where:

			nums                                           || out
			[1, 1, 2, 2, 2]                                || true
			[3, 3, 3, 3, 4]                                || false
			[]                                             || false
			[5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3]           || true
			[5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4] || false

	}

}
