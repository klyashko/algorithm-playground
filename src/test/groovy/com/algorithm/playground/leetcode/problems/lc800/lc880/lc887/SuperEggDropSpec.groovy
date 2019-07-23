package com.algorithm.playground.leetcode.problems.lc800.lc880.lc887

import spock.lang.Specification
import spock.lang.Unroll

class SuperEggDropSpec extends Specification {

    @Unroll
    def "superEggDrop"() {

        expect:

			new SuperEggDrop.Solution().superEggDrop(k, n) == output

        where:

            k || n  || output
            1 || 2  || 2
            2 || 6  || 3
            3 || 14 || 4
            1 || 1  || 1
            1 || 3  || 3
            2 || 2  || 2
            2 || 5  || 3
            2 || 4  || 3
            2 || 7  || 4
            2 || 8  || 4
            2 || 9  || 4
    }

}
