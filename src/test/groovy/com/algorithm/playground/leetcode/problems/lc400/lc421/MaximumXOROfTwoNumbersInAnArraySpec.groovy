package com.algorithm.playground.leetcode.problems.lc400.lc421

import com.algorithm.playground.leetcode.problems.lc400.lc421.MaximumXOROfTwoNumbersInAnArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximumXOROfTwoNumbersInAnArraySpec extends Specification {

	@Unroll
	def "findMaximumXOR"() {

		expect:

			new S().findMaximumXOR(nums as int[]) == output

		where:

			nums                 || output
			[3, 10, 5, 25, 2, 8] || 28

	}

}
