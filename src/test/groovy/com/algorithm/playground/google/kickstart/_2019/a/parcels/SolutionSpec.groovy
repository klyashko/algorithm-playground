package com.algorithm.playground.google.kickstart._2019.a.parcels

import com.algorithm.playground.google.kickstart._2019.a.parcels.Solution
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

	@Unroll
	def "solve"() {

		given:

			def rows = grid.size()
			def cols = grid[0].size()

		expect:

			Solution.solve(grid as int[][], rows, cols) == out

		where:

			grid              || out
			[[1, 0, 1],
			 [0, 0, 0],
			 [1, 0, 1]]       || 1
			[[1, 1]]          || 0
			[[1, 0, 0, 0, 1],
			 [0, 0, 0, 0, 0],
			 [0, 0, 0, 0, 0],
			 [0, 0, 0, 0, 0],
			 [1, 0, 0, 0, 1]] || 2
			[[0, 1, 0],
			 [0, 0, 0],
			 [0, 1, 0]]       || 1
			[[1, 1, 1],
			 [1, 1, 1],
			 [1, 1, 1]]       || 0

	}

}
