package com.leetcode.problems.heap.hard

import com.leetcode.problems.heap.hard.FindMedianFromDataStream.MedianFinder as MF
import spock.lang.Specification
import spock.lang.Unroll

class FindMedianFromDataStreamSpec extends Specification {

	@Unroll
	def "medianFinder"() {

		given:

			def mf = new MF()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					if (arg) {
						assert mf."$method"(arg) == result
					} else {
						assert mf."$method"() == result
					}
			}

		where:

			methods                                                                                                                                                                                                                                                                  | args                                                                                                 || results
			["addNum", "addNum", "findMedian", "addNum", "findMedian"]                                                                                                                                                                                                               | [[1], [2], [], [3], []]                                                                              || [null, null, 1.5, null, 2.0]
			["addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"]                                                                                                                                                 | [[-1], [], [-2], [], [-3], [], [-4], [], [-5], []]                                                   || [null, -1.0, null, -1.5, null, -2.0, null, -2.5, null, -3.0]
			["addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian"] | [[6], [], [10], [], [2], [], [6], [], [5], [], [0], [], [6], [], [3], [], [1], [], [0], [], [0], []] || [null, 6.0, null, 8.0, null, 6.0, null, 6.0, null, 6.0, null, 5.5, null, 6.0, null, 5.5, null, 5.0, null, 4.0, null, 3.0]

	}

}
