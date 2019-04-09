package com.algorithm.playground.leetcode.problems.trie.medium

import com.algorithm.playground.leetcode.problems.trie.medium.ImplementMagicDictionary.MagicDictionary as MD
import spock.lang.Specification
import spock.lang.Unroll

class ImplementMagicDictionarySpec extends Specification {

	@Unroll
	def "magicDictionary"() {

		given:

			def md = new MD()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (method == "buildDict") {
						md.buildDict(arg[0] as String[])
					} else {
						assert md."$method"(arg) == result
					}
			}

		where:

			methods                                               | args                                                                     || results
			["buildDict", "search", "search", "search", "search"] | [[["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]] || [null, false, true, false, false]

	}

}
