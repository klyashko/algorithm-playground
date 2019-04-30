package com.algorithm.playground.leetcode.problems.lc200.lc230.lc236;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class LowestCommonAncestorOfABinaryTree {

	class Solution {

		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			return lowestCommonAncestor(root, p, q, new int[]{0});
		}

		private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int[] count) {
			if (root == null || count[0] == 2) {
				return null;
			}
			if (root.val == p.val || root.val == q.val) {
				count[0]++;
				if (count[0] != 2) {
					lowestCommonAncestor(root.left, p, q, count);
					lowestCommonAncestor(root.right, p, q, count);
				}
				return root;
			} else {
				TreeNode left = lowestCommonAncestor(root.left, p, q, count);
				TreeNode right = lowestCommonAncestor(root.right, p, q, count);
				if (left != null && right != null) {
					return root;
				} else {
					return left != null ? left : right;
				}
			}
		}

	}

}
