package com.leetcode.problems.dynamic.programming.medium

import com.leetcode.problems.dynamic.programming.medium.KeysKeyboard.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class KeysKeyboardSpec extends Specification {

    @Unroll
    def "minSteps"() {

        expect:

            new S().minSteps(n) == output

        where:

            n || output
            3 || 3
            4 || 4
            6 || 5
            0 || 0

    }

}
