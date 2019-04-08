package com.algorithm.playground.leetcode.problems.lc200.lc230.lc230;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInABST {

	class Solution {

		public int kthSmallest(TreeNode root, int k) {
			int[] meta = new int[]{k, 0};
			inOrder(root, meta);
			return meta[1];
		}

		private void inOrder(TreeNode n, int[] meta) {
			if (n == null || meta[0] == 0) {
				return;
			}
			inOrder(n.left, meta);
			meta[0]--;
			if (meta[0] == 0) {
				meta[1] = n.val;
			}
			inOrder(n.right, meta);
		}
	}

}
