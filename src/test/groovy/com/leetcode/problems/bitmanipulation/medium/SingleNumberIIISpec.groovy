package com.leetcode.problems.bitmanipulation.medium

import com.leetcode.problems.bitmanipulation.medium.SingleNumberIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SingleNumberIIISpec extends Specification {

	@Unroll
	def "singleNumber"() {

		expect:

			new S().singleNumber(nums as int[]) == output as int[]

		where:

			nums               || output
			[1, 2, 1, 3, 2, 5] || [3, 5]

	}

}
