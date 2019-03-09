package com.algorithm.playground.leetcode.problems.dynamicprogramming.easy

import spock.lang.Specification
import spock.lang.Unroll

class RangeSumQueryImmutableSpec extends Specification {

    @Unroll
    def "sumRange"() {

        expect:

            new NumArray(input as int[]).sumRange(i, j) == output

        where:

            input                 || i || j || output
            [-2, 0, 3, -5, 2, -1] || 0 || 2 || 1
            [-2, 0, 3, -5, 2, -1] || 2 || 5 || -1
            [-2, 0, 3, -5, 2, -1] || 0 || 5 || -3
    }

}
