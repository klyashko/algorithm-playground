package com.algorithm.playground.leetcode.problems.lc0.lc30.lc34

import com.algorithm.playground.leetcode.problems.lc0.lc30.lc34.FindFirstAndLastPositionOfElementInSortedArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
class FindFirstAndLastPositionOfElementInSortedArraySpec extends Specification {

	@Unroll
	def "searchRange"() {

		expect:

			new S().searchRange(nums as int[], target) == out as int[]

		where:

			nums                | target || out
			[5, 7, 7, 8, 8, 10] | 8      || [3, 4]
			[5, 7, 7, 8, 8, 10] | 6      || [-1, -1]
			[2, 2]              | 3      || [-1, -1]

	}

}