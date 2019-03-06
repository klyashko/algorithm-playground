package com.leetcode.problems.lc0.lc85

import com.leetcode.problems.lc0.lc85.MaximalRectangle.SlowSolution as SS
import com.leetcode.problems.lc0.lc85.MaximalRectangle.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximalRectangleSpec extends Specification {

	@Unroll
	def "maximalRectangle"() {

		expect:

			new S().maximalRectangle(matrix as char[][]) == output

		where:

			matrix                                     || output
			[["1", "0", "1", "0", "0"],
			 ["1", "0", "1", "1", "1"],
			 ["1", "1", "1", "1", "1"],
			 ["1", "0", "0", "1", "0"]]                || 6
			[["1", "1", "1", "1", "1", "1", "1", "1"],
			 ["1", "1", "1", "1", "1", "1", "1", "0"],
			 ["1", "1", "1", "1", "1", "1", "1", "0"],
			 ["1", "1", "1", "1", "1", "0", "0", "0"],
			 ["0", "1", "1", "1", "1", "0", "0", "0"]] || 21

	}

	@Unroll
	def "maximalRectangle_slow"() {

		expect:

			new SS().maximalRectangle(matrix as char[][]) == output

		where:

			matrix                                     || output
			[["1", "0", "1", "0", "0"],
			 ["1", "0", "1", "1", "1"],
			 ["1", "1", "1", "1", "1"],
			 ["1", "0", "0", "1", "0"]]                || 6
			[["1", "1", "1", "1", "1", "1", "1", "1"],
			 ["1", "1", "1", "1", "1", "1", "1", "0"],
			 ["1", "1", "1", "1", "1", "1", "1", "0"],
			 ["1", "1", "1", "1", "1", "0", "0", "0"],
			 ["0", "1", "1", "1", "1", "0", "0", "0"]] || 21

	}

}
