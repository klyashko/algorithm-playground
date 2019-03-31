package com.algorithm.playground.leetcode.problems.lc0.lc40.lc45

import com.algorithm.playground.leetcode.problems.lc0.lc40.lc45.JumpGameII.Solution
import spock.lang.Specification
import spock.lang.Unroll

class JumpGameIISpec extends Specification {

    @Unroll
    def "jump"() {

        expect:

            new Solution().jump(input as int[]) == output

        where:

            input                 || output
            [2, 3, 1, 1, 4]       || 2
            [2, 2, 1, 1, 1, 2, 3] || 5
            [2, 2, 1, 4, 1, 2, 3] || 3
            [0]                   || 0
            [1]                   || 0
            [4, 1, 1, 3, 1, 1, 1] || 2

    }

}
