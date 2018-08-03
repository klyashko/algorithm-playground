package com.leetcode.problems.array.easy

import com.leetcode.problems.array.easy.ArrayPartitionI.Solution
import spock.lang.Specification

class ArrayPartitionISpec extends Specification {

	def "arrayPairSum"() {

		expect:
			4 == new Solution().arrayPairSum((int[]) [1, 4, 3, 2])

	}

}
