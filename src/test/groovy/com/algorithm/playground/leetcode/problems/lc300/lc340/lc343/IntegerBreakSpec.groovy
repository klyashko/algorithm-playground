package com.algorithm.playground.leetcode.problems.lc300.lc340.lc343

import spock.lang.Specification
import spock.lang.Unroll

class IntegerBreakSpec extends Specification {

    @Unroll
    def "integerBreak"() {

        expect:

			new IntegerBreak.Solution().integerBreak(n) == output

        where:

            n  || output
            2  || 1
            3  || 2
            5  || 6
            8  || 18
            10 || 36
    }

}
