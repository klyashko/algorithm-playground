package com.algorithm.playground.leetcode.problems.lc600.lc670.lc675

import spock.lang.Specification
import spock.lang.Unroll

class CutOffTreesForGolfEventSpec extends Specification {

	@Unroll
	def "cutOffTree"() {

		expect:

			new CutOffTreesForGolfEvent.Solution().cutOffTree(forest) == output

		where:

			forest                                     || output
			[[1, 2, 3],
			 [0, 0, 4],
			 [7, 6, 5]]                                || 6
			[[1, 2, 3],
			 [0, 0, 0],
			 [7, 6, 5]]                                || -1
			[[2, 3, 4],
			 [0, 0, 5],
			 [8, 7, 6]]                                || 6
			[[1, 1, 2],
			 [1, 1, 1],
			 [3, 1, 4]]                                || 8
			[[54581641, 64080174, 24346381, 69107959],
			 [86374198, 61363882, 68783324, 79706116],
			 [668150, 92178815, 89819108, 94701471],
			 [83920491, 22724204, 46281641, 47531096],
			 [89078499, 18904913, 25462145, 60813308]] || 57
			[[9, 12, 5, 14],
			 [17, 11, 13, 15],
			 [2, 20, 19, 21],
			 [16, 4, 7, 8],
			 [18, 3, 6, 10]]                           || 57

	}

	@Unroll
	def "cutOffTree_all_node_distances"() {

		expect:

			new CutOffTreesForGolfEvent.Solution().cutOffTree(forest) == output

		where:

			forest                                     || output
			[[1, 2, 3],
			 [0, 0, 4],
			 [7, 6, 5]]                                || 6
			[[1, 2, 3],
			 [0, 0, 0],
			 [7, 6, 5]]                                || -1
			[[2, 3, 4],
			 [0, 0, 5],
			 [8, 7, 6]]                                || 6
			[[1, 1, 2],
			 [1, 1, 1],
			 [3, 1, 4]]                                || 8
			[[54581641, 64080174, 24346381, 69107959],
			 [86374198, 61363882, 68783324, 79706116],
			 [668150, 92178815, 89819108, 94701471],
			 [83920491, 22724204, 46281641, 47531096],
			 [89078499, 18904913, 25462145, 60813308]] || 57
			[[9, 12, 5, 14],
			 [17, 11, 13, 15],
			 [2, 20, 19, 21],
			 [16, 4, 7, 8],
			 [18, 3, 6, 10]]                           || 57

	}

}
