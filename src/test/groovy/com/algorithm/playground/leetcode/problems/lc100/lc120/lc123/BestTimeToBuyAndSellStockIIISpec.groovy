package com.algorithm.playground.leetcode.problems.lc100.lc120.lc123

import com.algorithm.playground.leetcode.problems.lc100.lc120.lc123.BestTimeToBuyAndSellStockIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockIIISpec extends Specification {

	@Unroll
	def "maxProfit"() {

		expect:

			new S().maxProfit(prices as int[]) == out

		where:

			prices                   || out
			[3, 3, 5, 0, 0, 3, 1, 4] || 6
			[1, 2, 3, 4, 5]          || 4
			[7, 6, 4, 3, 1]          || 0
			[7, 6, 4, 3, 1, 0, 0]    || 0

	}


}
