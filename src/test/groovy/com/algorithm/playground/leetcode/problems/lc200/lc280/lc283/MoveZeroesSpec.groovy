package com.algorithm.playground.leetcode.problems.lc200.lc280.lc283

import com.algorithm.playground.leetcode.problems.lc200.lc280.lc283.MoveZeroes.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MoveZeroesSpec extends Specification {

	@Unroll
	def "moveZeroes"() {

		given:

			def values = nums as int[]

		when:

			new S().moveZeroes(values)

		then:

			values == output as int[]

		where:

			nums             || output
			[0, 1, 0, 3, 12] || [1, 3, 12, 0, 0]

	}

}
