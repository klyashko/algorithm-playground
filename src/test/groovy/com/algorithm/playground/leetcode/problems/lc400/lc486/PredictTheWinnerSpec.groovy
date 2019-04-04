package com.algorithm.playground.leetcode.problems.lc400.lc486

import com.algorithm.playground.leetcode.problems.lc400.lc486.PredictTheWinner.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class PredictTheWinnerSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "PredictTheWinner"() {

		expect:

			new S().PredictTheWinner(nums as int[]) == output

		where:

			nums             || output
			[1, 5, 2]        || false
			[1, 5, 233, 7]   || true
			[0]              || true
			[2, 4, 55, 6, 8] || false
			[1, 1, 1]        || true
			[1, 3, 1]        || false
			[1, 2, 99]       || true
			[1, 1]           || true

	}

}
