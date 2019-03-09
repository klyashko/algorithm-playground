package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium

import spock.lang.Specification
import spock.lang.Unroll

class KeysKeyboardSpec extends Specification {

    @Unroll
    def "minSteps"() {

        expect:

			new KeysKeyboard.Solution().minSteps(n) == output

        where:

            n || output
            3 || 3
            4 || 4
            6 || 5
            0 || 0

    }

}
