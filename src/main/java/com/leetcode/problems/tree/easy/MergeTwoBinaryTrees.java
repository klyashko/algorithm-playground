package com.leetcode.problems.tree.easy;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class MergeTwoBinaryTrees {

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
		public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
			if (t1 != null && t2 != null) {
				TreeNode node = new TreeNode(t1.val + t2.val);
				node.left = mergeTrees(t1.left, t2.left);
				node.right = mergeTrees(t1.right, t2.right);
				return node;
			}
			return t1 != null ? t1 : t2;
		}
	}

}
