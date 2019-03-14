package com.algorithm.playground.leetcode.problems.lc100.lc130.lc130

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc130.SurroundedRegions.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class SurroundedRegionsSpec extends Specification {

	@Unroll
	def "solve"() {

		given:

			def input = board as char[][]

		when:

			new S().solve(input)

		then:

			input == out as char[][]

		where:

			board                  || out
			[['X', 'X', 'X', 'X'],
			 ['X', 'O', 'O', 'X'],
			 ['X', 'X', 'O', 'X'],
			 ['X', 'O', 'X', 'X']] || [['X', 'X', 'X', 'X'],
									   ['X', 'X', 'X', 'X'],
									   ['X', 'X', 'X', 'X'],
									   ['X', 'O', 'X', 'X']]
	}

}
