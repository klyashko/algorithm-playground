package com.algorithm.playground.leetcode.problems.lc0.lc35

import com.algorithm.playground.leetcode.problems.lc0.lc35.SearchInsertPosition.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SearchInsertPositionSpec extends Specification {

	@Unroll
	def "searchInsert"() {

		expect:

			new S().searchInsert(nums as int[], target) == output

		where:

			nums         | target || output
			[1, 3, 5, 6] | 5      || 2
			[1, 3, 5, 6] | 2      || 1
			[1, 3, 5, 6] | 7      || 4
			[1, 3, 5, 6] | 0      || 0

	}

}
