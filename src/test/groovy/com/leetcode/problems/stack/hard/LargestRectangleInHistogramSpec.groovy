package com.leetcode.problems.stack.hard

import com.leetcode.problems.stack.hard.LargestRectangleInHistogram.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class LargestRectangleInHistogramSpec extends Specification {

	@Unroll
	def "largestRectangleArea"() {

		expect:

			new S().largestRectangleArea(heights as int[]) == output

		where:

			heights            || output
			[2, 1, 5, 6, 2, 3] || 10
			[]                 || 0
			[4, 2, 0, 3, 2, 5] || 6
			[1]                || 1

	}

}
