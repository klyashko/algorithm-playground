package com.leetcode.problems.dynamic.programming.easy

import com.leetcode.problems.dynamic.programming.easy.MinCostClimbingStairs.Solution
import spock.lang.Specification
import spock.lang.Unroll

class MinCostClimbingStairsSpec extends Specification {

    @Unroll
    def "minCostClimbingStairs"() {

        expect:

            new Solution().minCostClimbingStairs(input as int[]) == output

        where:

            input                                || output
            [10, 15, 20]                         || 15
            [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] || 6
            [0, 0, 0, 1]                         || 0

    }
}
