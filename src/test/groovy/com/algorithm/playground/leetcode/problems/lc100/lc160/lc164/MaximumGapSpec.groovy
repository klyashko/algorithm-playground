package com.algorithm.playground.leetcode.problems.lc100.lc160.lc164

import com.algorithm.playground.leetcode.problems.lc100.lc160.lc164.MaximumGap.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class MaximumGapSpec extends Specification {

	@Unroll
	def "maximumGap"() {

		expect:

			new S().maximumGap(nums as int[]) == output

		where:

			nums         || output
			[3, 6, 9, 1] || 3
			[10]         || 0

	}

}
