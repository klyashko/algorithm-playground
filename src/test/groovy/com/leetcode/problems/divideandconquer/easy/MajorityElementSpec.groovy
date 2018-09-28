package com.leetcode.problems.divideandconquer.easy

import com.leetcode.problems.divideandconquer.easy.MajorityElement.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MajorityElementSpec extends Specification {

	@Unroll
	def "majorityElement"() {

		expect:

			new S().majorityElement(nums as int[]) == output

		where:

			nums                  || output
			[3, 2, 3]             || 3
			[2, 2, 1, 1, 1, 2, 2] || 2

	}

}
