package com.leetcode.problems.trie.medium

import com.leetcode.problems.trie.medium.MapSumPairs.MapSum as MS
import spock.lang.Specification
import spock.lang.Unroll

class MapSumPairsSpec extends Specification {

	@Unroll
	def "mapSum"() {


		given:

			def ms = new MS()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert ms."$method"(arg) == result
			}

		where:

			methods                            | args                                       || results
			["insert", "sum", "insert", "sum"] | [["apple", 3], ["ap"], ["app", 2], ["ap"]] || [null, 3, null, 5]
			["insert", "sum", "insert", "sum"] | [["aa", 3], ["a"], ["aa", 2], ["a"]]       || [null, 3, null, 2]
	}

}
