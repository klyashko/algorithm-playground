package com.leetcode.problems.tree.hard;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class BinaryTreeMaximumPathSum {

	class Solution {
		public int maxPathSum(TreeNode root) {
			MaxPath max = maxPath(root);
			return (int) Math.max(max.t, max.full);
		}

		private MaxPath maxPath(TreeNode root) {
			MaxPath max = new MaxPath();
			if (root == null) {
				return max;
			}

			MaxPath left = maxPath(root.left);
			MaxPath right = maxPath(root.right);

			max.t = Math.max(Math.max(left.t + root.val, right.t + root.val), root.val);
			max.full = Math.max(
					Math.max(left.t + root.val, right.t + root.val),
					Math.max(left.t + right.t + root.val, root.val)
			);
			double fullMax = Math.max(left.full, right.full);
			max.full = Math.max(max.full, fullMax);
			return max;
		}

		private class MaxPath {
			double t, full;

			private MaxPath() {
				t = Double.NEGATIVE_INFINITY;
				full = Double.NEGATIVE_INFINITY;
			}
		}
	}

}
