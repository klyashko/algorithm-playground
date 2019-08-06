package com.algorithm.playground.leetcode.problems.lc400.lc440.lc442

import com.algorithm.playground.leetcode.problems.lc400.lc440.lc442.FindAllDuplicatesInAnArray.Solution
import spock.lang.Specification

class FindAllDuplicatesInAnArraySpec extends Specification {

	def "findDuplicates"() {

		expect:

			[2, 3] == new Solution().findDuplicates([4, 3, 2, 7, 8, 2, 3, 1] as int[])

	}

}
