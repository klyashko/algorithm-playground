package com.leetcode.problems.segmenttree.hard

import com.leetcode.problems.segmenttree.hard.RectangleAreaII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class RectangleAreaIISpec extends Specification {

	@Unroll
	def "rectangleArea"() {

		expect:

			new S().rectangleArea(rectangles as int[][]) == output

		where:

			rectangles                                 || output
			[[0, 0, 2, 2], [1, 0, 2, 3], [1, 0, 3, 1]] || 6
			[[0, 0, 1000000000, 1000000000]]           || 49
			[[0, 0, 3, 3], [2, 0, 5, 3], [1, 1, 4, 4]] || 18

	}

}
