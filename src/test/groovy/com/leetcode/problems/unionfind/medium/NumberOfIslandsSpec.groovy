package com.leetcode.problems.unionfind.medium

import com.leetcode.problems.unionfind.medium.NumberOfIslands.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class NumberOfIslandsSpec extends Specification {

	@Unroll
	def "numIslands"() {

		expect:

			new S().numIslands(grid as char[][]) == output

		where:

			grid                        || output
			[['1', '1', '1', '1', '0'],
			 ['1', '1', '0', '1', '0'],
			 ['1', '1', '0', '0', '0'],
			 ['0', '0', '0', '0', '0']] || 1
			[['1', '1', '0', '0', '0'],
			 ['1', '1', '0', '0', '0'],
			 ['0', '0', '1', '0', '0'],
			 ['0', '0', '0', '1', '1']] || 3

	}

}
