package com.leetcode.problems.lc400.lc414

import com.leetcode.problems.lc400.lc414.ThirdMaximumNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class ThirdMaximumNumberSpec extends Specification {

	@Unroll
	def "thirdMax"() {

		expect:

			new S().thirdMax(nums as int[]) == out

		where:

			nums         || out
			[3, 2, 1]    || 1
			[1, 2]       || 2
			[2, 2, 3, 1] || 1
			[5, 2, 2]    || 5

	}

}
