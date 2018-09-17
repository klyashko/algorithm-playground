package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {

	class Solution {
		public boolean isSymmetric(TreeNode root) {
			return root == null || isSymmetric(root.left, root.right);
		}

		private boolean isSymmetric(TreeNode n1, TreeNode n2) {
			if (n1 == null && n2 == null) {
				return true;
			} else if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
		}
	}

}
