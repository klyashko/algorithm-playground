package com.leetcode.problems.array.hard

import com.leetcode.problems.array.hard.WordLadderII.Solution;
import spock.lang.Specification
import spock.lang.Unroll

class WordLadderIISpec extends Specification {

    @Unroll
    def "findLadders"() {

        when:

            def l = new Solution().findLadders(begin, end, list)

        then:

            l.size() == expected.size()
            !expected.find {
                !l.contains(it)
            }

        where:

            begin || end   || list                                                     || expected
            "a"   || "c"   || ["a", "b", "c"]                                          || [["a", "c"]]
            "hit" || "cog" || ["hot", "dot", "dog", "lot", "log"]                      || []
            "hit" || "cog" || ["hot", "dot", "dog", "lot", "log", "cog"]               || [["hit", "hot", "dot", "dog", "cog"], ["hit", "hot", "lot", "log", "cog"]]
            "red" || "tax" || ["ted", "tex", "red", "tax", "tad", "den", "rex", "pee"] || [["red", "ted", "tad", "tax"], ["red", "ted", "tex", "tax"], ["red", "rex", "tex", "tax"]]
    }

}
