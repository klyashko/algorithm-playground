package com.leetcode.problems.dynamic.programming.hard

import com.leetcode.problems.dynamic.programming.hard.SuperEggDrop.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SuperEggDropSpec extends Specification {

    @Unroll
    def "superEggDrop"() {

        expect:

            new S().superEggDrop(k, n) == output

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
