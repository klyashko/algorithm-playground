package com.algorithm.playground.leetcode.problems.backtracking.medium

import com.algorithm.playground.leetcode.problems.backtracking.medium.CombinationSumIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class CombinationSumIIISpec extends Specification {

	@Unroll
	def "combinationSum3"() {

		expect:

			new S().combinationSum3(k, n) == output

		where:

			k | n || output
			3 | 7 || [[1, 2, 4]]
			3 | 9 || [[1, 2, 6], [1, 3, 5], [2, 3, 4]]

	}

}
