package com.leetcode.problems.lc910

import com.leetcode.problems.lc910.SmallestRangeII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SmallestRangeIISpec extends Specification {

	@Unroll
	def "smallestRangeII"() {

		expect:

			new S().smallestRangeII(nums as int[], k) == out

		where:

			nums         | k || out
			[1]          | 0 || 0
			[0, 10]      | 2 || 6
			[1, 3, 6]    | 3 || 3
			[7, 8, 8]    | 5 || 1
			[3, 4, 7, 0] | 5 || 7

	}

}
