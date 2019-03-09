package com.algorithm.playground.leetcode.problems.lc0.lc70


import spock.lang.Specification
import spock.lang.Unroll

class ClimbingStairsSpec extends Specification {

    @Unroll
    def "climbStairs"() {

        expect:

			new ClimbingStairs.Solution().climbStairs(input) == output

        where:

            input || output
            2     || 2
            3     || 3

    }

}
