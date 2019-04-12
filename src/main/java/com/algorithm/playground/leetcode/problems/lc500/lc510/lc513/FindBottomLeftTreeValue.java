package com.algorithm.playground.leetcode.problems.lc500.lc510.lc513;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */
public class FindBottomLeftTreeValue {

	class Solution {
		public int findBottomLeftValue(TreeNode root) {
			return dfs(root, 0)[1];
		}

		private int[] dfs(TreeNode n, int depth) {
			if (n == null) {
				return new int[]{-1, 0};
			}
			if (n.left == null && n.right == null) {
				return new int[]{depth, n.val};
			}
			int[] left = dfs(n.left, depth + 1);
			int[] right = dfs(n.right, depth + 1);

			if (left[0] < right[0]) {
				return right;
			}
			return left;
		}
	}

}
