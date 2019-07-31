package com.algorithm.playground.leetcode.problems.lc200.lc230.lc235;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class LowestCommonAncestorOfABinarySearchTree {

	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			int left = Math.min(p.val, q.val);
			int right = Math.max(p.val, q.val);
			if (root.val >= left && root.val <= right) {
				return root;
			} else if (root.val < p.val) {
				return lowestCommonAncestor(root.right, p, q);
			} else {
				return lowestCommonAncestor(root.left, p, q);
			}
		}
	}

}
