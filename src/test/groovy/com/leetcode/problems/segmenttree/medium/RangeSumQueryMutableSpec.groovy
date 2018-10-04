package com.leetcode.problems.segmenttree.medium

import spock.lang.Specification
import spock.lang.Unroll

import static com.leetcode.problems.segmenttree.medium.RangeSumQueryMutable.numArray

class RangeSumQueryMutableSpec extends Specification {

	@Unroll
	def "numArray"() {

		given:

			def na = numArray(nums as int[])

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert na."$method"(arg) == result
			}

		where:

			nums      | methods                            | args                     || results
			[1, 3, 5] | ["sumRange", "update", "sumRange"] | [[0, 2], [1, 2], [0, 2]] || [9, null, 8]

	}

	@Unroll
	def "numArray_quick_check"() {

		given:

			def na = numArray(nums as int[])

		expect:

			[methods, args].transpose()
					.each { method, arg -> println("$method with ($arg) result: ${na."$method"(arg)}") }

		where:

			nums                                           | methods                                                                                                        | args
			[-28, -39, 53, 65, 11, -56, -65, -39, -43, 97] | ["sumRange", "update", "sumRange", "sumRange", "update", "update", "sumRange", "sumRange", "update", "update"] | [[5, 6], [9, 27], [2, 3], [6, 7], [1, -82], [3, -72], [3, 7], [1, 8], [5, 13], [4, -67]]

	}

	@Unroll
	def "numArray_empty"() {

		expect:

			numArray(new int[0])

	}

}
