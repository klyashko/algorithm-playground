package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium

import spock.lang.Specification
import spock.lang.Unroll

class CountNumbersWithUniqueDigitsSpec extends Specification {

    @Unroll
    def "countNumbersWithUniqueDigits"() {

        expect:

			new CountNumbersWithUniqueDigits.Solution().countNumbersWithUniqueDigits(n) == output

        where:

            n || output
            2 || 91
            3 || 739 //261
            0 || 1

    }

    @Unroll
    def "countNumbersWithUniqueDigitsRecursive"() {

        expect:

			new CountNumbersWithUniqueDigits.SolutionRecursive().countNumbersWithUniqueDigits(n) == output

        where:

            n || output
            2 || 91
            3 || 739 //261
            0 || 1

    }

}
