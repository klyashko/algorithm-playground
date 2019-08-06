package com.algorithm.playground.leetcode.problems.lc500.lc538;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * <p>
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 */
public class ConvertBSTToGreaterTree {

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

		public TreeNode convertBST(TreeNode root) {
			sum(root, 0);
			return root;
		}

		private int sum(TreeNode node, int sum) {
			if (node == null) {
				return sum;
			}
			int right = sum(node.right, sum);
			node.val += right;
			return sum(node.left, node.val);
		}

	}

}
