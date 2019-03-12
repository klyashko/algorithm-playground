package com.algorithm.playground.leetcode.problems.lc900.lc968;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 */
public class BinaryTreeCameras {

	class Solution {
		public int minCameraCover(TreeNode root) {
			int[] count = {0};
			if (minCameraCover(root, count) > 0) {
				count[0]++;
			}
			return count[0];
		}

		private int minCameraCover(TreeNode root, int[] count) {
			if (root == null) {
				return 0;
			}
			int left = minCameraCover(root.left, count);
			int right = minCameraCover(root.right, count);
			if (left == 1 || right == 1) {
				count[0]++;
				return -1;
			}
			return Math.min(left, right) + 1;
		}

	}

}
