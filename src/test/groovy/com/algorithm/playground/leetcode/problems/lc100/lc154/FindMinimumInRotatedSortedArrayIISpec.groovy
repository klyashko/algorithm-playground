package com.algorithm.playground.leetcode.problems.lc100.lc154

import com.algorithm.playground.leetcode.problems.lc100.lc154.FindMinimumInRotatedSortedArrayII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FindMinimumInRotatedSortedArrayIISpec extends Specification {

	@Unroll
	def "findMin"() {

		expect:

			new S().findMin(nums as int[]) == out

		where:

			nums            || out
			[1, 3, 5]       || 1
			[2, 2, 2, 0, 1] || 0

	}

}
