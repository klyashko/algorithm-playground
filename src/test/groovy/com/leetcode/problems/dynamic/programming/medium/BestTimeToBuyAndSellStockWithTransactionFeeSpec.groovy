package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.BestTimeToBuyAndSellStockWithTransactionFee.Solution
import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockWithTransactionFeeSpec extends Specification {

    @Unroll
    def "maxProfit"() {

        expect:

            new Solution().maxProfit(prices as int[], fee) == output

        where:

            prices                          || fee || output
            [1, 3, 2, 8, 4, 9]              || 2   || 8
            [1, 3, 2, 8, 4, 9, 2, 10]       || 2   || 14
            [1, 3, 2, 8, 4, 9, 2, 10, 1, 5] || 2   || 16

    }

}
