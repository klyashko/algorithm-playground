package com.algorithm.playground.leetcode.problems.lc200.lc220.lc226

import com.algorithm.playground.leetcode.problems.lc200.lc220.lc226.InvertBinaryTree.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

import static com.algorithm.playground.leetcode.problems.utils.tree.TreeNode.node

/**
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 */
class InvertBinaryTreeSpec extends Specification {

	@Unroll
	def "invertTree"() {

		expect:

			new S().invertTree(node(root)) == node(out)

		where:

			root                  || out
			[4, 2, 7, 1, 3, 6, 9] || [4, 7, 2, 9, 6, 3, 1]

	}

}