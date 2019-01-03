package com.leetcode.problems.breadthfirstsearch.hard

import com.leetcode.problems.breadthfirstsearch.hard.SlidingPuzzle.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SlidingPuzzleSpec extends Specification {

	@Unroll
	def "slidingPuzzle"() {

		expect:

			new S().slidingPuzzle(board as int[][]) == out

		where:

			board                  || out
			[[1, 2, 3], [4, 0, 5]] || 1
			[[1, 2, 3], [5, 4, 0]] || -1
			[[4, 1, 2], [5, 0, 3]] || 5
			[[3, 2, 4], [1, 5, 0]] || 14

	}

}
