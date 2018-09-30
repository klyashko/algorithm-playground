package com.leetcode.problems.dynamicprogramming.medium

import com.leetcode.problems.dynamicprogramming.medium.ArithmeticSlices.Solution
import spock.lang.Specification
import spock.lang.Unroll

class ArithmeticSlicesSpec extends Specification {

	@Unroll
	def "numberOfArithmeticSlices"() {

		expect:

			new Solution().numberOfArithmeticSlices(input as int[]) == output

		where:

			input               || output
			[1, 2, 3, 4]        || 3
			[1, 2, 3, 8, 9, 10] || 2
			[]                  || 0

	}

}
