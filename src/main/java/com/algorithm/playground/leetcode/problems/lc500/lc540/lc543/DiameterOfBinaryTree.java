package com.algorithm.playground.leetcode.problems.lc500.lc540.lc543;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterOfBinaryTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {

		public int diameterOfBinaryTree(TreeNode root) {
			int[] max = new int[1];
			dfs(root, max);
			return max[0];
		}

		private int dfs(TreeNode node, int[] max) {
			if (node == null) {
				return 0;
			}
			int left = dfs(node.left, max);
			int right = dfs(node.right, max);
			max[0] = Math.max(max[0], left + right);
			return Math.max(left, right) + 1;
		}

	}

}
