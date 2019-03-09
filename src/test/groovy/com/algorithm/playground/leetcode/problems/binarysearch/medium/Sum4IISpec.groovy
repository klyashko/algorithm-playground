package com.algorithm.playground.leetcode.problems.binarysearch.medium

import com.algorithm.playground.leetcode.problems.binarysearch.medium.Sum4II.FastSolution as FS
import com.algorithm.playground.leetcode.problems.binarysearch.medium.Sum4II.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class Sum4IISpec extends Specification {

	@Unroll
	def "fourSumCount"() {

		expect:

			new S().fourSumCount(A as int[], B as int[], C as int[], D as int[]) == output

		where:

			A          | B          | C         | D          || output
			[1, 2]     | [-2, -1]   | [-1, 2]   | [0, 2]     || 2
			[0, 1, -1] | [-1, 1, 0] | [0, 0, 1] | [-1, 1, 1] || 17
			[0]        | [0]        | [0]       | [0]        || 1
			[-1, -1]   | [-1, 1]    | [-1, 1]   | [1, -1]    || 6

	}

	@Unroll
	def "fourSumCount_fast"() {

		expect:

			new FS().fourSumCount(A as int[], B as int[], C as int[], D as int[]) == output

		where:

			A          | B          | C         | D          || output
			[1, 2]     | [-2, -1]   | [-1, 2]   | [0, 2]     || 2
			[0, 1, -1] | [-1, 1, 0] | [0, 0, 1] | [-1, 1, 1] || 17
			[0]        | [0]        | [0]       | [0]        || 1
			[-1, -1]   | [-1, 1]    | [-1, 1]   | [1, -1]    || 6

	}

}
