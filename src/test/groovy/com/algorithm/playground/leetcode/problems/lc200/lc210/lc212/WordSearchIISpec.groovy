package com.algorithm.playground.leetcode.problems.lc200.lc210.lc212

import com.algorithm.playground.leetcode.problems.lc200.lc210.lc212.WordSearchII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class WordSearchIISpec extends Specification {

	@Unroll
	def "findWords"() {

		expect:

			new S().findWords(board as char[][], words as String[]) as Set == output as Set

		where:

			board                  | words                          || output
			[['o', 'a', 'a', 'n'],
			 ['e', 't', 'a', 'e'],
			 ['i', 'h', 'k', 'r'],
			 ['i', 'f', 'l', 'v']] | ["oath", "pea", "eat", "rain"] || ["eat", "oath"]
			[["a"]]                | ["a"]                          || ["a"]

	}

}
