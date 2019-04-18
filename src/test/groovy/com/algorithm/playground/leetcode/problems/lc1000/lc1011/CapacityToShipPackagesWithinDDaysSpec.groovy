package com.algorithm.playground.leetcode.problems.lc1000.lc1011

import com.algorithm.playground.leetcode.problems.lc1000.lc1011.CapacityToShipPackagesWithinDDays.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 *
 *
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 *
 *
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
class CapacityToShipPackagesWithinDDaysSpec extends Specification {

	@Unroll
	def "shipWithinDays"() {

		expect:

			new S().shipWithinDays(weights as int[], d) == out

		where:

			weights                         | d || out
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5 || 15
			[3, 2, 2, 4, 1, 4]              | 3 || 6
			[1, 2, 3, 1, 1]                 | 4 || 3

	}

}
