package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.IntegerBreak.Solution
import spock.lang.Specification
import spock.lang.Unroll

class IntegerBreakSpec extends Specification {

    @Unroll
    def "integerBreak"() {

        expect:

            new Solution().integerBreak(n) == output

        where:

            n  || output
            2  || 1
            3  || 2
            5  || 6
            8  || 18
            10 || 36
    }

}
