package com.algorithm.playground.leetcode.problems.lc0.lc80.lc81

import com.algorithm.playground.leetcode.problems.lc0.lc80.lc81.SearchInRotatedSortedArrayII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 */
class SearchInRotatedSortedArrayIISpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "search"() {

		expect:

			new S().search(nums as int[], target) == out

		where:

			nums                  | target || out
			[2, 5, 6, 0, 0, 1, 2] | 0      || true
			[2, 5, 6, 0, 0, 1, 2] | 3      || false
			[1]                   | 1      || true
			[1, 3]                | 1      || true

	}

}
