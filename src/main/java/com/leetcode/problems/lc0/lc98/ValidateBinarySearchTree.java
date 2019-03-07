package com.leetcode.problems.lc0.lc98;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

	class Solution {
		public boolean isValidBST(TreeNode root) {
			return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		private boolean isValidBST(TreeNode root, long min, long max) {
			if (root == null) {
				return true;
			} else if (root.val <= min || root.val >= max) {
				return false;
			} else return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}
	}

}
