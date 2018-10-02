package com.leetcode.problems.binarysearchtree.medium

import com.leetcode.problems.binarysearchtree.medium.MyCalendarII.MyCalendarTwo as MCT
import spock.lang.Specification
import spock.lang.Unroll

class MyCalendarIISpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyAssignabilityCheck")
	def "myCalendarTwo"() {

		given:

			def mct = new MCT()

		expect:

			[args, results].transpose().each {
				arg, result ->
					println("book with ($arg) expect $result")
					assert mct.book(*arg) == result
			}

		where:

			args                                                                                               || results
			[[10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]                                         || [true, true, true, false, true, true]
			[[26, 35], [26, 32], [25, 32], [18, 26], [40, 45], [19, 26], [48, 50], [1, 6], [46, 50], [11, 18]] || [true, true, false, true, true, true, true, true, true, true]
			[[24, 40], [43, 50], [27, 43], [5, 21], [30, 40], [14, 29], [3, 19], [3, 14], [25, 39], [6, 19]]   || [true, true, true, true, false, false, true, false, false, false]


	}

}
