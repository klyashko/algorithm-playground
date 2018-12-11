package com.leetcode.problems.array.easy

import com.leetcode.problems.array.easy.MissingNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MissingNumberSpec extends Specification {

	@Unroll
	def "missingNumber"() {

		expect:

			new S().missingNumber(nums as int[]) == out

		where:

			nums                        || out
			[3, 0, 1]                   || 2
			[9, 6, 4, 2, 3, 5, 7, 0, 1] || 8

	}

}
