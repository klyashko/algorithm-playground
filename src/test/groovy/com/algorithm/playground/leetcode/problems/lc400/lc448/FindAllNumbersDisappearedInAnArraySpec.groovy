package com.algorithm.playground.leetcode.problems.lc400.lc448

import com.algorithm.playground.leetcode.problems.lc400.lc448.FindAllNumbersDisappearedInAnArray.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
class FindAllNumbersDisappearedInAnArraySpec extends Specification {

	@Unroll
	def "findDisappearedNumbers"() {

		expect:

			new S().findDisappearedNumbers(nums as int[]) == out

		where:

			nums                     || out
			[4, 3, 2, 7, 8, 2, 3, 1] || [5, 6]

	}

}