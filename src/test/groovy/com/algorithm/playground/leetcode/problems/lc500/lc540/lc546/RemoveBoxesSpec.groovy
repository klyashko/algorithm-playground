package com.algorithm.playground.leetcode.problems.lc500.lc540.lc546

import spock.lang.Specification
import spock.lang.Unroll

class RemoveBoxesSpec extends Specification {

	@Unroll
	def "removeBoxes"() {

		expect:

			new RemoveBoxes.Solution().removeBoxes(boxes as int[]) == output

		where:

			boxes                       || output
			[1, 3, 2, 2, 2, 3, 4, 3, 1] || 23

	}

}
