package com.algorithm.playground.leetcode.problems.lc400.lc470.lc477

import com.algorithm.playground.leetcode.problems.lc400.lc470.lc477.TotalHammingDistance.Solution as S
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
