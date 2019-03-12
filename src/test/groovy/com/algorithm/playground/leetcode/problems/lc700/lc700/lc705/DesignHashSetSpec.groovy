package com.algorithm.playground.leetcode.problems.lc700.lc700.lc705

import com.algorithm.playground.leetcode.problems.lc700.lc700.lc705.DesignHashSet.MyHashSet as HS
import spock.lang.Specification
import spock.lang.Unroll

class DesignHashSetSpec extends Specification {

	@Unroll
	def "myHashSet"() {

		given:

			def hs = new HS()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert hs."$method"(arg) == result
			}

		where:

			methods                                                                         | args                                     || results
			["add", "add", "contains", "contains", "add", "contains", "remove", "contains"] | [[1], [2], [1], [3], [2], [2], [2], [2]] || [null, null, true, false, null, true, null, false]
	}

}
