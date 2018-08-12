package com.leetcode.problems.dynamic.programming.easy

import com.leetcode.problems.dynamic.programming.easy.BestTimeToBuyAndSellStock.Solution
import spock.lang.Specification
import spock.lang.Unroll

class BestTimeToBuyAndSellStockSpec extends Specification {

    @Unroll
    def "maxProfit"() {

        expect:

            new Solution().maxProfit(input as int[]) == output

        where:

            input              || output
            [7, 1, 5, 3, 6, 4] || 5
            [7, 6, 4, 3, 1]    || 0

    }

}
