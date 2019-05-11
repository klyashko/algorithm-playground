package com.algorithm.playground.google.kickstart._2019.a.task2

import spock.lang.Specification
import spock.lang.Unroll

class ParcelsSpec extends Specification {

	@Unroll
	def "solve"() {

		given:

			def rows = grid.size()
			def cols = grid[0].size()

		expect:

			Solution.solve(grid as char[][], rows, cols) == out

		where:

			grid                        || out
			[['1', '0', '1'],
			 ['0', '0', '0'],
			 ['1', '0', '1']]           || 1
			[['1', '1']]                || 0
			[['1', '0', '0', '0', '1'],
			 ['0', '0', '0', '0', '0'],
			 ['0', '0', '0', '0', '0'],
			 ['0', '0', '0', '0', '0'],
			 ['1', '0', '0', '0', '1']] || 2
			[['0', '1', '0'],
			 ['0', '0', '0'],
			 ['0', '1', '0']]           || 1
			[['1', '1', '1'],
			 ['1', '1', '1'],
			 ['1', '1', '1']]           || 0

	}

}
