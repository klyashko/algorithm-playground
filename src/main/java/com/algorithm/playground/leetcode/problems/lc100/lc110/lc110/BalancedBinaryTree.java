package com.algorithm.playground.leetcode.problems.lc100.lc110.lc110;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

	class Solution {
		public boolean isBalanced(TreeNode root) {
			return checkDepth(root) != -1;
		}

		private int checkDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int left = checkDepth(root.left);
			int right = checkDepth(root.right);
			if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
				return -1;
			} else {
				return Math.max(left, right) + 1;
			}
		}
	}

}
