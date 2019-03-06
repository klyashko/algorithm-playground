package com.leetcode.problems.lc500.lc561

import com.leetcode.problems.lc500.lc561.Solution as S
import spock.lang.Specification

class ArrayPartitionISpec extends Specification {

	def "arrayPairSum"() {

		expect:
			4 == new S().arrayPairSum([1, 4, 3, 2] as int[])

	}

}
