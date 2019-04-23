package com.algorithm.playground.leetcode.problems.lc900.lc983

import com.algorithm.playground.leetcode.problems.lc900.lc983.MinimumCostForTickets.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 *
 *
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
class MinimumCostForTicketsSpec extends Specification {

	@Unroll
	def "mincostTickets"() {

		expect:

			new S().mincostTickets(days as int[], costs as int[]) == out

		where:

			days                                                                                                                                                                                                                                                        | costs       || out
			[1, 4, 6, 7, 8, 20]                                                                                                                                                                                                                                         | [2, 7, 15]  || 11
			[1, 4, 6, 7, 8]                                                                                                                                                                                                                                             | [2, 7, 15]  || 9
			[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]                                                                                                                                                                                                                     | [2, 7, 15]  || 17
			[3, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 21, 23, 25, 26, 27, 29, 30, 33, 34, 35, 36, 38, 39, 40, 42, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 59, 60, 61, 63, 64, 67, 68, 69, 70, 72, 74, 77, 78, 79, 80, 81, 82, 83, 84, 85, 88, 91, 92, 93, 96] | [3, 17, 57] || 170

	}

}
