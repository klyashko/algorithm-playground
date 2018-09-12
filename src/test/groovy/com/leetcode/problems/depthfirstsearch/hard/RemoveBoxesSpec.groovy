package com.leetcode.problems.depthfirstsearch.hard

import com.leetcode.problems.depthfirstsearch.hard.RemoveBoxes.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RemoveBoxesSpec extends Specification {

	@Unroll
	def "removeBoxes"() {

		expect:

			new S().removeBoxes(boxes as int[]) == output

		where:

			boxes                       || output
			[1, 3, 2, 2, 2, 3, 4, 3, 1] || 23

	}

}
