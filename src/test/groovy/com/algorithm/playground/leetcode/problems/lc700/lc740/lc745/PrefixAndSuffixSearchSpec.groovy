package com.algorithm.playground.leetcode.problems.lc700.lc740.lc745

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc700.lc740.lc745.PrefixAndSuffixSearch.wordFilter

class PrefixAndSuffixSearchSpec extends Specification {

	@Unroll
	def "wordFilter"() {

		given:

			def wf = wordFilter(words as String[])

		expect:

			[args, results].transpose().each {
				arg, result ->
					println("f with ($arg) expect $result")
					assert wf.f(*arg) == result
			}

		where:

			words     | args                                                                                                                                                                                                                                                                                                                                                                                                                            || results
			["apple"] | [["a", "e"]]                                                                                                                                                                                                                                                                                                                                                                                                                    || [0]
			["pop"]   | [["", ""], ["", "p"], ["", "op"], ["", "pop"], ["p", ""], ["p", "p"], ["p", "op"], ["p", "pop"], ["po", ""], ["po", "p"], ["po", "op"], ["po", "pop"], ["pop", ""], ["pop", "p"], ["pop", "op"], ["pop", "pop"], ["", ""], ["", "p"], ["", "gp"], ["", "pgp"], ["p", ""], ["p", "p"], ["p", "gp"], ["p", "pgp"], ["pg", ""], ["pg", "p"], ["pg", "gp"], ["pg", "pgp"], ["pgp", ""], ["pgp", "p"], ["pgp", "gp"], ["pgp", "pgp"]] | [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
	}

}
