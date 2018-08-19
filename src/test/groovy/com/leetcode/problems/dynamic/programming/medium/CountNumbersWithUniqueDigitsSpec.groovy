package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.CountNumbersWithUniqueDigits.Solution
import spock.lang.Specification
import spock.lang.Unroll

class CountNumbersWithUniqueDigitsSpec extends Specification {

    @Unroll
    def "countNumbersWithUniqueDigits"() {

        expect:

            new Solution().countNumbersWithUniqueDigits(n) == output

        where:

            n || output
            2 || 91
            3 || 739 //261
            0 || 1

    }

}
