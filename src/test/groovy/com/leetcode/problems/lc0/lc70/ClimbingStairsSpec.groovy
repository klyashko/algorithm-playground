package com.leetcode.problems.lc0.lc70

import com.leetcode.problems.lc0.lc70.ClimbingStairs.Solution
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
