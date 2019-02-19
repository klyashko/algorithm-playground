package com.leetcode.problems.array.easy

import com.leetcode.problems.array.easy.NonDecreasingArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NonDecreasingArraySpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
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
