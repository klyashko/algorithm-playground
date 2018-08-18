package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.MaximumLengthOfPairChain.Solution
import spock.lang.Specification
import spock.lang.Unroll

class MaximumLengthOfPairChainSpec extends Specification {

    @Unroll
    def "findLongestChain"() {

        expect:

            new Solution().findLongestChain(input as int[][]) == output

        where:

            input                                                                   || output
            [[1, 2], [2, 3], [3, 4]]                                                || 2
            [[3, 4], [2, 3], [1, 2]]                                                || 2
            [[-6, 9], [1, 6], [8, 10], [-1, 4], [-6, -2], [-9, 8], [-5, 3], [0, 3]] || 3
            [[-9, 8], [-6, 9], [-6, -2], [-5, 3], [-1, 4], [0, 3], [1, 6], [8, 10]] || 3
            [[-6, -2], [-5, 3], [0, 3], [-1, 4], [1, 6], [-9, 8], [-6, 9], [8, 10]] || 3
            [[7, 9], [4, 5], [7, 9], [-7, -1], [0, 10], [3, 10], [3, 6], [2, 3]]    || 4
            [[-7, -1], [2, 3], [4, 5], [7, 9]]                                      || 4
            [[-7, -1], [0, 10], [2, 3], [3, 10], [3, 6], [4, 5], [7, 9], [7, 9]]    || 4
    }

}
