package com.algorithm.playground.leetcode.problems.lc200.lc260

import com.algorithm.playground.leetcode.problems.lc200.lc260.SingleNumberIII.FastSolution as FS
import com.algorithm.playground.leetcode.problems.lc200.lc260.SingleNumberIII.Solution as S
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

	@Unroll
	def "singleNumber_fast"() {

		expect:

			new FS().singleNumber(nums as int[]) as Set == output as Set

		where:

			nums               || output
			[1, 2, 1, 3, 2, 5] || [3, 5]

	}

}
