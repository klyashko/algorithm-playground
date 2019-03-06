package com.leetcode.problems.lc500.lc554

import com.leetcode.problems.lc500.lc554.BrickWall.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BrickWallSpec extends Specification {

	@Unroll
	def "leastBricks"() {

		expect:

			new S().leastBricks(wall) == out

		where:

			wall                                    || out
			[[1, 2, 2, 1]]                          || 0
			[[1, 2, 2, 1],
			 [3, 1, 2],
			 [1, 3, 2],
			 [2, 4],
			 [3, 1, 2],
			 [1, 3, 1, 1]]                          || 2
			[[1], [1], [1]]                         || 3
			[[100000000], [100000000], [100000000]] || 3

	}

}
