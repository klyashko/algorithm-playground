package com.leetcode.problems.hash.table.hard

import com.leetcode.problems.hash.table.hard.MaximalRectangle.Solution as S
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

}
