package com.algorithm.playground.leetcode.problems.lc500.lc538

import com.algorithm.playground.leetcode.problems.lc500.lc538.ConvertBSTToGreaterTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
class ConvertBSTToGreaterTreeSpec extends Specification {

	@Unroll
	def "convertBST"() {

		expect:

			new S().convertBST(node(root)) == node(out)

		where:

			root                   || out
			[5, 2, 13]             || [18, 20, 13]
			[2, 0, 3, -4, 1]       || [5, 6, 3, 2, 6]
			[1, 0, 4, -2, null, 3] || [8, 8, 4, 6, null, 7]

	}

}