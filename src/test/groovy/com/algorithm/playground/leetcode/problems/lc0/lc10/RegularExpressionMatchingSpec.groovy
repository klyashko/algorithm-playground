package com.algorithm.playground.leetcode.problems.lc0.lc10

import com.algorithm.playground.leetcode.problems.lc0.lc10.RegularExpressionMatching
import spock.lang.Specification
import spock.lang.Unroll

class RegularExpressionMatchingSpec extends Specification {

    @Unroll
    @SuppressWarnings("GroovyPointlessBoolean")
    def "isMatch"() {

        expect:

			new RegularExpressionMatching.Solution().isMatch(str, pattern) == output

        where:

            str                   || pattern              || output
            "aa"                  || "a*"                 || true
            "ab"                  || ".*"                 || true
            "aab"                 || "c*a*b*"             || true
            "mississippi"         || "mis*is*p*."         || false
            "aaa"                 || "aaaa"               || false
            "ab"                  || ".*c"                || false
            "aaa"                 || "a*a"                || true
            "a"                   || "ab*"                || true
            "a"                   || "ab*a"               || false
            "bbbba"               || ".*a*a"              || true
            "b"                   || "aaa."               || false
            "ba"                  || ".*."                || true
            "abcaaaaaaabaabcabac" || ".*ab.a.*a*a*.*b*b*" || true

    }

}
