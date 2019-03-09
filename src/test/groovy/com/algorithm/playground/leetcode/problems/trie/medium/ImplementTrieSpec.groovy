package com.algorithm.playground.leetcode.problems.trie.medium

import com.algorithm.playground.leetcode.problems.trie.medium.ImplementTrie.Trie as T
import spock.lang.Specification
import spock.lang.Unroll

class ImplementTrieSpec extends Specification {

	@Unroll
	def "trie"() {
		given:

			def t = new T()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert t."$method"(arg) == result
					} else {
						assert t."$method"() == result
					}
			}

		where:

			methods                                                          | args                                                       || results
			["insert", "search", "search", "startsWith", "insert", "search"] | [["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]] || [null, true, false, true, null, true]
	}

}
