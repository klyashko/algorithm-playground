package com.algorithm.playground.leetcode.problems.lc0.lc30.lc31

import com.algorithm.playground.leetcode.problems.lc0.lc30.lc31.NextPermutation.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NextPermutationSpec extends Specification {

	@Unroll
	def "nextPermutation"() {

		given:

			def input = nums as int[]

		when:

			new S().nextPermutation(input)

		then:

			input == out as int[]

		where:

			nums      || out
			[1, 2, 3] || [1, 3, 2]
			[3, 2, 1] || [1, 2, 3]
			[1, 1, 5] || [1, 5, 1]
			[1, 3, 2] || [2, 1, 3]
			[1, 5, 1] || [5, 1, 1]

	}

}