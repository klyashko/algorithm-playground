package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/description/
 */
public class BinaryTreePruning {

	class Solution {
		public TreeNode pruneTree(TreeNode root) {
			return dfs(root) ? root : null;
		}

		private boolean dfs(TreeNode n) {
			if (n == null) {
				return false;
			}

			boolean left = dfs(n.left);
			boolean right = dfs(n.right);

			if (!left) {
				n.left = null;
			}
			if (!right) {
				n.right = null;
			}
			return n.val == 1 || left || right;
		}
	}

}
