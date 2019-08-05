package com.algorithm.playground.leetcode.problems.lc100.lc110.lc114

import com.algorithm.playground.leetcode.problems.lc100.lc110.lc114.FlattenBinaryTreeToLinkedList.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
class FlattenBinaryTreeToLinkedListSpec extends Specification {

	@Unroll
	def "flatten"() {

		given:

			def tree = node(values)

		when:

			new S().flatten(tree)

		then:

			tree == node(out)

		where:

			values                   || out
			[1, 2, 5, 3, 4, null, 6] || [1, null, 2, null, 3, null, 4, null, 5, null, 6]

	}

}