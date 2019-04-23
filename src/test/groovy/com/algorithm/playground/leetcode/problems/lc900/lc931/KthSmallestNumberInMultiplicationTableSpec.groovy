package com.algorithm.playground.leetcode.problems.lc900.lc931

import com.algorithm.playground.leetcode.problems.lc900.lc931.KthSmallestNumberInMultiplicationTable.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 *
 * Input: m = 2, n = 3, k = 6
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 *
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 *
 * The m and n will be in the range [1, 30000].
 * The k will be in the range [1, m * n]
 */
class KthSmallestNumberInMultiplicationTableSpec extends Specification {

	@Unroll
	def "findKthNumber"() {

		expect:

			new S().findKthNumber(m, n, k) == out

		where:

			m  | n  | k   || out
			3  | 3  | 5   || 3
			2  | 3  | 6   || 6
			1  | 3  | 3   || 3
			3  | 1  | 3   || 3
			9  | 9  | 81  || 81
			45 | 12 | 471 || 312
			42 | 34 | 401 || 126

	}

}
