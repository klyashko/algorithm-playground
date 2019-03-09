package com.algorithm.playground.leetcode.problems.lc500.lc561


import spock.lang.Specification

class ArrayPartitionISpec extends Specification {

	def "arrayPairSum"() {

		expect:
			4 == new Solution().arrayPairSum([1, 4, 3, 2] as int[])

	}

}
