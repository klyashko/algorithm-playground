package com.leetcode.problems.dynamicprogramming.easy

import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockSpec extends Specification {

    @Unroll
    def "maxProfit"() {

        expect:

			new BestTimeToBuyAndSellStock.Solution().maxProfit(input as int[]) == output

        where:

            input              || output
            [7, 1, 5, 3, 6, 4] || 5
            [7, 6, 4, 3, 1]    || 0

    }

}
