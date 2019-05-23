package com.algorithm.playground.leetcode.problems.lc0.lc62

import com.algorithm.playground.leetcode.problems.lc0.lc62.UniquePaths.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class UniquePathsSpec extends Specification {

	@Unroll
	def "uniquePaths"() {

		expect:

			new S().uniquePaths(m, n) == out

		where:

			m | n || out
			3 | 2 || 3
			7 | 3 || 28

	}

}
