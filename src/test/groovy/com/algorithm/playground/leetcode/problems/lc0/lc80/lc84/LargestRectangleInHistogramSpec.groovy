package com.algorithm.playground.leetcode.problems.lc0.lc80.lc84

import com.algorithm.playground.leetcode.problems.lc0.lc80.lc84.LargestRectangleInHistogram.SimpleSolution as SS
import com.algorithm.playground.leetcode.problems.lc0.lc80.lc84.LargestRectangleInHistogram.Solution as S
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
			[2, 1, 2]          || 3
			[]                 || 0
			[4, 2, 0, 3, 2, 5] || 6
			[1]                || 1

	}

	@Unroll
	def "largestRectangleArea_simple"() {

		expect:

			new SS().largestRectangleArea(heights as int[]) == output

		where:

			heights            || output
			[2, 1, 5, 6, 2, 3] || 10
			[2, 1, 2]          || 3
			[]                 || 0
			[4, 2, 0, 3, 2, 5] || 6
			[1]                || 1

	}

}
