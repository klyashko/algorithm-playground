package com.algorithm.playground.leetcode.problems.lc800.lc890.lc895

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 *
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 */
class FreqStackSpec extends Specification {

	@Unroll
	def "FreqStack"() {

		given:

			def fs = new FreqStack()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert fs."$method"(arg) == result
					} else {
						assert fs."$method"() == result
					}
			}

		where:

			methods                                                                                                                                                || args                                                                                       || results
			["push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]                                                                           || [[5], [7], [5], [7], [4], [5], [], [], [], []]                                             || [null, null, null, null, null, null, 5, 7, 5, 4]
			["push", "push", "push", "push", "push", "push", "pop", "push", "pop", "push", "pop", "push", "pop", "push", "pop", "pop", "pop", "pop", "pop", "pop"] || [[4], [0], [9], [3], [4], [2], [], [6], [], [1], [], [1], [], [4], [], [], [], [], [], []] || [null, null, null, null, null, null, 4, null, 6, null, 1, null, 1, null, 4, 2, 3, 9, 0, 4]

	}

}