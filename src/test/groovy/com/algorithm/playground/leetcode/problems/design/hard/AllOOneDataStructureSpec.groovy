package com.algorithm.playground.leetcode.problems.design.hard

import com.algorithm.playground.leetcode.problems.design.hard.AllOOneDataStructure.AllOne as AO
import spock.lang.Specification
import spock.lang.Unroll

class AllOOneDataStructureSpec extends Specification {

	@Unroll
	def "allOne"() {

		given:

			def ao = new AO()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert ao."$method"(arg) == result
					} else {
						assert ao."$method"() == result
					}
			}

		where:

			methods                                                                                                | args                                                                        || results
			["getMaxKey", "getMinKey"]                                                                             | [[], []]                                                                    || ["", ""]
			["inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]                              | [["hello"], ["hello"], [], [], ["leet"], [], []]                            || [null, null, "hello", "hello", null, "hello", "leet"]
			["inc", "inc", "inc", "inc", "inc", "inc", "dec", "dec", "getMinKey", "dec", "getMaxKey", "getMinKey"] | [["a"], ["b"], ["b"], ["c"], ["c"], ["c"], ["b"], ["b"], [], ["a"], [], []] || [null, null, null, null, null, null, null, null, "a", null, "c", "c"]

	}

}
