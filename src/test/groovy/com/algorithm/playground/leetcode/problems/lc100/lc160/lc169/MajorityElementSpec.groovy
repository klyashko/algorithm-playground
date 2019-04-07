package com.algorithm.playground.leetcode.problems.lc100.lc160.lc169

import spock.lang.Specification
import spock.lang.Unroll

class MajorityElementSpec extends Specification {

	@Unroll
	def "majorityElement"() {

		expect:

			new MajorityElement.Solution().majorityElement(nums as int[]) == output

		where:

			nums                  || output
			[3, 2, 3]             || 3
			[2, 2, 1, 1, 1, 2, 2] || 2

	}

}
