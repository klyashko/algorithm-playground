package com.algorithm.playground.leetcode.problems.lc200.lc220.lc226;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * <p>
 * Invert a binary tree.
 */
public class InvertBinaryTree {

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

		public TreeNode invertTree(TreeNode root) {
			if (root == null) {
				return null;
			}
			TreeNode left = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(left);
			return root;
		}

	}

}
