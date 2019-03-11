package com.algorithm.playground.leetcode.problems.lc300.lc338

import com.algorithm.playground.leetcode.problems.lc300.lc338.CountingBits
import spock.lang.Specification
import spock.lang.Unroll

class CountingBitsSpec extends Specification {

    @Unroll
    def "countBits"() {

        expect:

			new CountingBits.Solution().countBits(input) == output as int[]

        where:

            input || output
            2     || [0, 1, 1]
            5     || [0, 1, 1, 2, 1, 2]
            8     || [0, 1, 1, 2, 1, 2, 2, 3, 1]
            16    || [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1]

    }

}
