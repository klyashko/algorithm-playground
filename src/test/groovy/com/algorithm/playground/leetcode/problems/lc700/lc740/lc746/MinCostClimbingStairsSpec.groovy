package com.algorithm.playground.leetcode.problems.lc700.lc740.lc746

import spock.lang.Specification
import spock.lang.Unroll

class MinCostClimbingStairsSpec extends Specification {

    @Unroll
    def "minCostClimbingStairs"() {

        expect:

			new MinCostClimbingStairs.Solution().minCostClimbingStairs(input as int[]) == output

        where:

            input                                || output
            [10, 15, 20]                         || 15
            [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] || 6
            [0, 0, 0, 1]                         || 0

    }
}
