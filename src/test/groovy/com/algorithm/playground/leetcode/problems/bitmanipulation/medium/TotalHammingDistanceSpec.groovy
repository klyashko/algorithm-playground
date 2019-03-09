package com.algorithm.playground.leetcode.problems.bitmanipulation.medium

import com.algorithm.playground.leetcode.problems.bitmanipulation.medium.TotalHammingDistance.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TotalHammingDistanceSpec extends Specification {

	@Unroll
	def "totalHammingDistance"() {

		expect:

			new S().totalHammingDistance(nums as int[]) == output

		where:

			nums       || output
			[4, 14, 2] || 6

	}

}
