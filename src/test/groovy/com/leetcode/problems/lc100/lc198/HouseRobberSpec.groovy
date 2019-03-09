package com.leetcode.problems.lc100.lc198

import com.leetcode.problems.lc100.lc198.HouseRobber
import spock.lang.Specification
import spock.lang.Unroll

class HouseRobberSpec extends Specification {

    @Unroll
    def "rob"() {

        expect:

			new HouseRobber.Solution().rob(input as int[]) == output

        where:

            input           || output
            [1, 2, 3, 1]    || 4
            [2, 7, 9, 3, 1] || 12
            [2, 1, 1, 2]    || 4

    }

}
