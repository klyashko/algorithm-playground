package com.algorithm.playground.leetcode.problems.lc0.lc30.lc33

import com.algorithm.playground.leetcode.problems.lc0.lc30.lc33.SearchInRotatedSortedArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
class SearchInRotatedSortedArraySpec extends Specification {

	@Unroll
	def "search"() {

		expect:

			new S().search(nums as int[], target) == out

		where:

			nums                  | target || out
			[4, 5, 6, 7, 0, 1, 2] | 0      || 4
			[4, 5, 6, 7, 0, 1, 2] | 3      || -1
			[5, 1, 3]             | 5      || 0
			[0, 1, 3]             | 1      || 1
			[]                    | 5      || -1
			[1]                   | 0      || -1

	}

}