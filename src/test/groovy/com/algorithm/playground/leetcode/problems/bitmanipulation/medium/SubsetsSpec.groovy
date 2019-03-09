package com.algorithm.playground.leetcode.problems.bitmanipulation.medium

import com.algorithm.playground.leetcode.problems.bitmanipulation.medium.Subsets.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SubsetsSpec extends Specification {

	@Unroll
	def "subsets"() {

		expect:

			new S().subsets(nums as int[]) as Set == output as Set

		where:

			nums      || output
			[1, 2, 3] || [[3],
						  [1],
						  [2],
						  [1, 2, 3],
						  [1, 3],
						  [2, 3],
						  [1, 2],
						  []]

	}

}
