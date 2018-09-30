package com.leetcode.problems.dynamicprogramming.easy

import com.leetcode.problems.dynamicprogramming.easy.ClimbingStairs.Solution
import spock.lang.Specification
import spock.lang.Unroll

class ClimbingStairsSpec extends Specification {

    @Unroll
    def "climbStairs"() {

        expect:

            new Solution().climbStairs(input) == output

        where:

            input || output
            2     || 2
            3     || 3

    }

}
