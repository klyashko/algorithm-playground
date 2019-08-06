package com.algorithm.playground.leetcode.problems.lc0.lc0.lc1

import com.algorithm.playground.leetcode.problems.lc0.lc0.lc1.TwoSum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class TwoSumSpec extends Specification {

	@Unroll
	def "twoSum"() {

		expect:

			new S().twoSum(nums as int[], target) == out as int[]

		where:

			nums           | target || out
			[2, 7, 11, 15] | 9      || [0, 1]

	}

}