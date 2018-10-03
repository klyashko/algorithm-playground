package com.leetcode.problems.binarysearchtree.hard

import com.leetcode.problems.binarysearchtree.hard.MyCalendarIII.MyCalendarThree as MCT
import spock.lang.Specification
import spock.lang.Unroll

class MyCalendarIIISpec extends Specification {

	@Unroll
	def "myCalendarThree"() {

		given:

			def mct = new MCT()

		expect:

			[args, results].transpose().each {
				arg, result ->
					println("book with ($arg) expect $result")
					assert mct.book(*arg) == result
			}

		where:

			args                                                       || results
			[[10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]] || [1, 1, 2, 3, 3, 3]

	}

}
