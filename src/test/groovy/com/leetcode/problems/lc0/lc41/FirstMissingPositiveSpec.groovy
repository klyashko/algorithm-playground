package com.leetcode.problems.lc0.lc41

import com.leetcode.problems.lc0.lc41.FirstMissingPositive.Solution
import spock.lang.Specification
import spock.lang.Unroll

class FirstMissingPositiveSpec extends Specification {

    @Unroll
    def "firstMissingPositive"() {

        expect:

            new Solution().firstMissingPositive(input as int[]) == output

        where:

            input             || output
            [1, 2, 0]         || 3
            [3, 4, -1, 1]     || 2
            [7, 8, 9, 11, 12] || 1
            [1]               || 2
            [1, 1]            || 2

    }

}
