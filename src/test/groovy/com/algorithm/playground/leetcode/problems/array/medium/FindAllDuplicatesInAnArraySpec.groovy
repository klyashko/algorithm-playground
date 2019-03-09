package com.algorithm.playground.leetcode.problems.array.medium

import com.algorithm.playground.leetcode.problems.array.medium.FindAllDuplicatesInAnArray.Solution
import spock.lang.Specification

class FindAllDuplicatesInAnArraySpec extends Specification {

	def "findDuplicates"() {

		expect:

			[2, 3] == new Solution().findDuplicates([4, 3, 2, 7, 8, 2, 3, 1] as int[])

	}

}
