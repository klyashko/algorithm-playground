package com.algorithm.playground.leetcode.problems.lc100.lc110.lc111;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {

	class Solution {
		public int minDepth(TreeNode root) {
			if (root == null) {
				return 0;
			} else if (root.left == null && root.right == null) {
				return 1;
			}
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			if (root.left == null || root.right == null) {
				return left + right + 1;
			}
			return Math.min(left, right) + 1;

		}
	}

}
