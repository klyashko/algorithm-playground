package com.algorithm.playground.leetcode.problems.lc300.lc352

import com.algorithm.playground.leetcode.problems.lc300.lc352.DataStreamAsDisjointIntervals.SummaryRanges as SR
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.sort.Interval.valueOf as i

class DataStreamAsDisjointIntervalsSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "summaryRanges"() {

		given:

			def sr = new SR()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert sr."$method"(arg) == result
					} else {
						assert sr."$method"() == i(result)
					}
			}

		where:

			methods                                                                                                                                                                                                                                                              | args                                                                                       || results
//			["addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]                                                                                                                                   | [[1], [], [3], [], [7], [], [2], [], [6], []]                                              || [null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//			["addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]                                                                                                                                                                                       | [[1], [], [9], [], [2], []]                                                                || [null, [[1, 1]], null, [[1, 1], [9, 9]], null, [[1, 2], [9, 9]]]
			["addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"] | [[6], [], [6], [], [0], [], [4], [], [8], [], [7], [], [6], [], [4], [], [7], [], [5], []] || [null, [[6, 6]], null, [[6, 6]], null, [[0, 0], [6, 6]], null, [[0, 0], [4, 4], [6, 6]], null, [[0, 0], [4, 4], [6, 6], [8, 8]], null, [[0, 0], [4, 4], [6, 8]], null, [[0, 0], [4, 4], [6, 8]], null, [[0, 0], [4, 4], [6, 8]], null, [[0, 0], [4, 4], [6, 8]], null, [[0, 0], [4, 8]]]

	}

}
