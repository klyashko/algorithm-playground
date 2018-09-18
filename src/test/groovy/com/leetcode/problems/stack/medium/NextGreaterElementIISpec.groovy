package com.leetcode.problems.stack.medium

import com.leetcode.problems.stack.medium.NextGreaterElementII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NextGreaterElementIISpec extends Specification {

	@Unroll
	def "nextGreaterElements"() {

		expect:

			new S().nextGreaterElements(nums as int[]) == output as int[]

		where:

			nums            || output
			[1, 2, 1]       || [2, -1, 2]
			[1, 2, 3, 4, 3] || [2, 3, 4, -1, 4]

	}

}
