package com.algorithm.playground.leetcode.problems.lc700.lc700.lc703

import spock.lang.Specification
import spock.lang.Unroll

import static KthLargestElementInAStream.kthLargest

class KthLargestElementInAStreamSpec extends Specification {

	@Unroll
	def "kthLargest"() {

		given:

			def kl = kthLargest(k, nums as int[])

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert kl."$method"(arg) == result
			}

		where:

			k | nums         | methods                             | args                       || results
			3 | [4, 5, 8, 2] | ["add", "add", "add", "add", "add"] | [[3], [5], [10], [9], [4]] || [4, 5, 5, 8, 8]
	}

	@Unroll
	def "kthLargest_quick_check"() {

		given:

			def kl = kthLargest(k, nums as int[])

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result got ${kl."$method"(arg)}")
			}

		where:

			k | nums         | methods                             | args                       || results
			3 | [4, 5, 8, 2] | ["add", "add", "add", "add", "add"] | [[3], [5], [10], [9], [4]] || [4, 5, 5, 8, 8]
	}

}
