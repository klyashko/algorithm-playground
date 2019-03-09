package com.algorithm.playground.leetcode.problems.lc800.lc847

import com.algorithm.playground.leetcode.problems.lc800.lc847.ShortestPathVisitingAllNodes
import spock.lang.Specification
import spock.lang.Unroll

class ShortestPathVisitingAllNodesSpec extends Specification {

    @Unroll
    def "shortestPathLength"() {

        expect:

			new ShortestPathVisitingAllNodes.Solution().shortestPathLength(graph as int[][]) == output

        where:

            graph                                    || output
            [[1, 2, 3], [0], [0], [0]]               || 4
            [[1], [0, 2, 4], [1, 3, 4], [2], [1, 2]] || 4

    }

}
