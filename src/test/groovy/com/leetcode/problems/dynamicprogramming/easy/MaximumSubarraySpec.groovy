package com.leetcode.problems.dynamicprogramming.easy

import spock.lang.Specification
import spock.lang.Unroll

class MaximumSubarraySpec extends Specification {

    @Unroll
    def "maxSubArray"() {

        expect:

			new MaximumSubarray.Solution().maxSubArray(input as int[]) == output

        where:

            input                           || output
            [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
            [-1]                            || -1
            [-2, 1]                         || 1
            [-2, -1]                        || -1
            [1, -1, -2]                     || 1
            [2, 0, -3, 2, 1, 0, 1, -2]      || 4

    }

}
