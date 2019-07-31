package com.algorithm.playground.leetcode.problems.lc100.lc100.lc104;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {

	class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}

}
