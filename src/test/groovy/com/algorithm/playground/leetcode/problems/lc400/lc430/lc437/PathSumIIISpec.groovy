package com.algorithm.playground.leetcode.problems.lc400.lc430.lc437

import com.algorithm.playground.leetcode.problems.lc400.lc430.lc437.PathSumIII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
class PathSumIIISpec extends Specification {

	@Unroll
	def "pathSum"() {

		expect:

			new S().pathSum(node(values), sum) == out

		where:

			values                                      | sum || out
			[10, 5, -3, 3, 2, null, 11, 3, -2, null, 1] | 8   || 3

	}

}