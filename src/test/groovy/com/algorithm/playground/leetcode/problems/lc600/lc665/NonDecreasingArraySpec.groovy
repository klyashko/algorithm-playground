package com.algorithm.playground.leetcode.problems.lc600.lc665

import com.algorithm.playground.leetcode.problems.lc600.lc665.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NonDecreasingArraySpec extends Specification {

	@Unroll
	def "checkPossibility"() {

		expect:

			new S().checkPossibility(nums as int[]) == out

		where:

			nums         || out
			[4, 2, 3]    || true
			[4, 2, 1]    || false
			[3, 4, 2, 3] || false

	}

}
