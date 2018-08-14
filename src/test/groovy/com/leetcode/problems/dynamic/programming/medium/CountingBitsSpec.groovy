package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.CountingBits.Solution
import spock.lang.Specification
import spock.lang.Unroll

class CountingBitsSpec extends Specification {

    @Unroll
    def "countBits"() {

        expect:

            new Solution().countBits(input) == output as int[]

        where:

            input || output
            2     || [0, 1, 1]
            5     || [0, 1, 1, 2, 1, 2]
            8     || [0, 1, 1, 2, 1, 2, 2, 3, 1]
            16    || [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1]

    }

}
