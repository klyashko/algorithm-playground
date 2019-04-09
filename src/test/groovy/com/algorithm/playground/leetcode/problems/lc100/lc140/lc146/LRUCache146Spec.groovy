package com.algorithm.playground.leetcode.problems.lc100.lc140.lc146

import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.lc100.lc140.lc146.LRUCache146.lruCache as cache

class LRUCache146Spec extends Specification {

	@Unroll
	def "LRUCache"() {

		given:

			def cache = cache(capacity)

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert cache."$method"(arg) == result
			}

		where:

			capacity | methods                                                         | args                                                      || results
			2        | ["put", "put", "get", "put", "get", "put", "get", "get", "get"] | [[1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]] || [null, null, 1, null, -1, null, -1, 3, 4]
			2        | ["put", "put", "put", "put", "get", "get"]                      | [[2, 1], [1, 1], [2, 3], [4, 1], [1], [2]]                || [null, null, null, null, -1, 3]

	}

}
