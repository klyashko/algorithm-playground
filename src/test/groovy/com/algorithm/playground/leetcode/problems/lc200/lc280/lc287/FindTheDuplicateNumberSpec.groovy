package com.algorithm.playground.leetcode.problems.lc200.lc280.lc287

import com.algorithm.playground.leetcode.problems.lc200.lc280.lc287.FindTheDuplicateNumber.PigeonholeSolution as PS
import com.algorithm.playground.leetcode.problems.lc200.lc280.lc287.FindTheDuplicateNumber.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class FindTheDuplicateNumberSpec extends Specification {

	@Unroll
	def "findDuplicate"() {

		expect:

			new S().findDuplicate(nums as int[]) == output

		where:

			nums            || output
			[1, 3, 4, 2, 2] || 2
			[3, 1, 3, 4, 2] || 3

	}

	@Unroll
	def "findDuplicate_pigeonhole"() {

		expect:

			new PS().findDuplicate(nums as int[]) == output

		where:

			nums            || output
			[1, 3, 4, 2, 2] || 2
			[3, 1, 3, 4, 2] || 3

	}

}
