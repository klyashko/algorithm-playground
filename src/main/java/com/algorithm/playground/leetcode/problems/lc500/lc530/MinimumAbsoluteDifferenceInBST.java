package com.algorithm.playground.leetcode.problems.lc500.lc530;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class MinimumAbsoluteDifferenceInBST {

	class Solution {
		public int getMinimumDifference(TreeNode root) {
			return traverse(root, new int[]{-1, Integer.MAX_VALUE});
		}

		private int traverse(TreeNode node, int[] meta) {
			if (node == null) {
				return Integer.MAX_VALUE;
			}
			traverse(node.left, meta);
			if (meta[0] != -1) {
				meta[1] = Math.min(meta[1], node.val - meta[0]);
			}
			meta[0] = node.val;
			traverse(node.right, meta);
			return meta[1];
		}
	}

}
