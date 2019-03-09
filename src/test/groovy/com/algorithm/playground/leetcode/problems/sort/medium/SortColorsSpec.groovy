package com.algorithm.playground.leetcode.problems.sort.medium

import com.algorithm.playground.leetcode.problems.sort.medium.SortColors.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SortColorsSpec extends Specification {

	@Unroll
	def "sortColors"() {

		given:

			def values = nums as int[]

		when:

			new S().sortColors(values)

		then:

			values == output as int[]

		where:

			nums               || output
			[2, 0, 2, 1, 1, 0] || [0, 0, 1, 1, 2, 2]

	}

}
