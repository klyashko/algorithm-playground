package com.algorithm.playground.leetcode.problems.math.easy

import com.algorithm.playground.leetcode.problems.math.easy.SelfDividingNumbers.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SelfDividingNumbersSpec extends Specification {

	@Unroll
	def "selfDividingNumbers"() {

		expect:

			new S().selfDividingNumbers(left, right) == output

		where:

			left || right || output
			1    || 22    || [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
			10   || 10    || []

	}

}
