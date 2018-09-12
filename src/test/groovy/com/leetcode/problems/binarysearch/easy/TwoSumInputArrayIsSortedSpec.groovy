package com.leetcode.problems.binarysearch.easy

import com.leetcode.problems.binarysearch.easy.TwoSumInputArrayIsSorted.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class TwoSumInputArrayIsSortedSpec extends Specification {

	@Unroll
	def "twoSum"() {

		expect:

			new S().twoSum(numbers as int[], target) == output as int[]

		where:

			numbers                       | target || output
			[2, 7, 11, 15]                | 9      || [1, 2]
			[2, 3, 4]                     | 6      || [1, 3]
			[3, 24, 50, 79, 88, 150, 345] | 200    || [3, 6]

	}

}
