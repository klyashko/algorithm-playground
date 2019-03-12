package com.algorithm.playground.leetcode.problems.lc300.lc327

import com.algorithm.playground.leetcode.problems.lc300.lc327.CountOfRangeSum
import spock.lang.Specification
import spock.lang.Unroll

class CountOfRangeSumSpec extends Specification {

	@Unroll
	def "countRangeSum"() {

		expect:

			new CountOfRangeSum.Solution().countRangeSum(nums as int[], lower, upper) == output

		where:

			nums                  | lower | upper || output
			[-2, 5, -1]           | -2    | 2     || 3
			[-1, 1]               | 0     | 0     || 1
			[]                    | 0     | 0     || 0
			[0, -3, -3, 1, 1, 2]  | 3     | 5     || 2
			[-3, 1, 2, -2, 2, -1] | -3    | -1    || 7
			[0, -1, 1, 2, -3, -3] | -3    | 1     || 13

	}

}
