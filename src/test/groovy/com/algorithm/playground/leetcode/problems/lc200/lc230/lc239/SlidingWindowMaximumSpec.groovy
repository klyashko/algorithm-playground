package com.algorithm.playground.leetcode.problems.lc200.lc230.lc239

import com.algorithm.playground.leetcode.problems.lc200.lc230.lc239.SlidingWindowMaximum.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
class SlidingWindowMaximumSpec extends Specification {

	@Unroll
	def "maxSlidingWindow"() {

		expect:

			new S().maxSlidingWindow(nums as int[], k) == out as int[]

		where:

			nums                       | k || out
			[1, 3, -1, -3, 5, 3, 6, 7] | 3 || [3, 3, 5, 5, 6, 7]
			[]                         | 0 || []
			[1, -1]                    | 1 || [1, -1]

	}

}