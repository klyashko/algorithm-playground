package com.algorithm.playground.leetcode.problems.lc500.lc560

import com.algorithm.playground.leetcode.problems.lc500.lc560.SubarraySumEqualsK.CamSumSolution as CSS
import com.algorithm.playground.leetcode.problems.lc500.lc560.SubarraySumEqualsK.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SubarraySumEqualsKSpec extends Specification {

	@Unroll
	def "subarraySum"() {

		expect:

			new S().subarraySum(nums as int[], k) == out

		where:

			nums      | k || out
			[1, 1, 1] | 2 || 2

	}

	@Unroll
	def "subarraySum_CamSum"() {

		expect:

			new CSS().subarraySum(nums as int[], k) == out

		where:

			nums      | k || out
			[1, 1, 1] | 2 || 2

	}

}
