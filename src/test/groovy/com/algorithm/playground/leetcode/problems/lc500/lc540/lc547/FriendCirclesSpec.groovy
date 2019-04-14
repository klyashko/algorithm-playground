package com.algorithm.playground.leetcode.problems.lc500.lc540.lc547

import com.algorithm.playground.leetcode.problems.lc500.lc540.lc547.FriendCircles.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FriendCirclesSpec extends Specification {

	@Unroll
	def "findCircleNum"() {

		expect:

			new S().findCircleNum(M as int[][]) == output

		where:

			M           || output
			[[1, 1, 0],
			 [1, 1, 0],
			 [0, 0, 1]] || 2
			[[1, 1, 0],
			 [1, 1, 1],
			 [0, 1, 1]] || 1

	}

}
