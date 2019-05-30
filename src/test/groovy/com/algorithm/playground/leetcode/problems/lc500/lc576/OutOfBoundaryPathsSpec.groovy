package com.algorithm.playground.leetcode.problems.lc500.lc576

import com.algorithm.playground.leetcode.problems.lc500.lc576.OutOfBoundaryPaths.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class OutOfBoundaryPathsSpec extends Specification {

	@Unroll
	def "findPaths"() {

		expect:

			new S().findPaths(m, n, N, i, j) == out

		where:

			m  | n  | N  | i  | j  || out
			2  | 2  | 2  | 0  | 0  || 6
			1  | 3  | 3  | 0  | 1  || 12
			8  | 50 | 23 | 5  | 26 || 914783380
			36 | 5  | 50 | 15 | 3  || 390153306


	}

}
