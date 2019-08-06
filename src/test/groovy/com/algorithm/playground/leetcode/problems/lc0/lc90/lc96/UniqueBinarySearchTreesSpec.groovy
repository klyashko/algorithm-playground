package com.algorithm.playground.leetcode.problems.lc0.lc90.lc96

import com.algorithm.playground.leetcode.problems.lc0.lc90.lc96.UniqueBinarySearchTrees.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
class UniqueBinarySearchTreesSpec extends Specification {

	@Unroll
	def "numTrees"() {

		expect:

			new S().numTrees(n) == out

		where:

			n || out
			3 || 5
			4 || 14

	}

}