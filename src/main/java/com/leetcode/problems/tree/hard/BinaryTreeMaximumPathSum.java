package com.leetcode.problems.tree.hard;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class BinaryTreeMaximumPathSum {

	class Solution {
		public int maxPathSum(TreeNode root) {
			int[] max = new int[]{root.val};
			int i = dfs(root, max);
			return Math.max(max[0], Math.max(root.val, i));
		}

		private int dfs(TreeNode n, int[] max) {
			if (n == null) {
				return Integer.MIN_VALUE / 10;
			}
			int l = dfs(n.left, max);
			int r = dfs(n.right, max);
			int m = Math.max(l, r);

			max[0] = Math.max(
					Math.max(l + r + n.val, n.val),
					Math.max(max[0], m)
			);
			return Math.max(
					Math.max(l + n.val, r + n.val), n.val
			);
		}
	}

	class Solution_ {
		public int maxPathSum(TreeNode root) {
			MaxPath max = maxPath(root);
			return (int) Math.max(max.intermediate, max.full);
		}

		private MaxPath maxPath(TreeNode root) {
			MaxPath max = new MaxPath();
			if (root == null) {
				return max;
			}

			MaxPath left = maxPath(root.left);
			MaxPath right = maxPath(root.right);

			max.intermediate = Math.max(Math.max(left.intermediate + root.val, right.intermediate + root.val), root.val);
			max.full = Math.max(
					Math.max(left.intermediate + root.val, right.intermediate + root.val),
					Math.max(left.intermediate + right.intermediate + root.val, root.val)
			);
			double fullMax = Math.max(left.full, right.full);
			max.full = Math.max(max.full, fullMax);
			return max;
		}

		private class MaxPath {
			double intermediate, full;

			private MaxPath() {
				intermediate = Double.NEGATIVE_INFINITY;
				full = Double.NEGATIVE_INFINITY;
			}
		}
	}

}
