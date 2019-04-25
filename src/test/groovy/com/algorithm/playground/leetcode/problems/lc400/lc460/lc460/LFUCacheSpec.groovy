package com.algorithm.playground.leetcode.problems.lc400.lc460.lc460

import spock.lang.Specification
import spock.lang.Unroll

class LFUCacheSpec extends Specification {

	@Unroll
	def "lfuCache"() {

		given:

			def cache = new LFUCache(capacity)

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert cache."$method"(arg) == result
			}

		where:

			capacity | methods                                                                       | args                                                                || results
			2        | ["put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]        | [[1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]      || [null, null, 1, null, -1, 3, null, -1, 3, 4]
			0        | ["put", "get"]                                                                | [[0, 0], [0]]                                                       || [null, -1]
			3        | ["put", "put", "get", "get", "get", "put", "put", "get", "get", "get", "get"] | [[2, 2], [1, 1], [2], [1], [2], [3, 3], [4, 4], [3], [2], [1], [4]] || [null, null, 2, 1, 2, null, null, -1, 2, 1, 4]
			2        | ["put", "put", "put", "put", "get"]                                           | [[3, 1], [2, 1], [2, 2], [4, 4], [2]]                               || [null, null, null, null, 2]

	}

}
