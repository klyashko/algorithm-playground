package com.algorithm.playground.leetcode.problems.recursion.easy;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
public class LongestUnivaluePath {

	class Solution {
		public int longestUnivaluePath(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int max = max(root.left, root.val) + max(root.right, root.val);
			max = Math.max(max, longestUnivaluePath(root.left));
			max = Math.max(max, longestUnivaluePath(root.right));
			return max;
		}

		private int max(TreeNode node, int val) {
			if (node == null || node.val != val) {
				return 0;
			}
			return Math.max(max(node.left, val), max(node.right, val)) + 1;
		}
	}

}
