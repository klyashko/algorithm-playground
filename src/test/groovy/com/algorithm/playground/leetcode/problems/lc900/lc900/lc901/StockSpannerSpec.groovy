package com.algorithm.playground.leetcode.problems.lc900.lc900.lc901

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: ["next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 */
class StockSpannerSpec extends Specification {

	@Unroll
	def "StockSpanner"() {

		given:

			def ss = new StockSpanner()

		expect:

			[args, results].transpose().each {
				arg, result ->
					println("next with ($arg) expect $result")
					assert ss.next(arg) == result
			}

		where:

			args                                        || results
			[[100], [80], [60], [70], [60], [75], [85]] || [1, 1, 1, 2, 1, 4, 6]

	}

}