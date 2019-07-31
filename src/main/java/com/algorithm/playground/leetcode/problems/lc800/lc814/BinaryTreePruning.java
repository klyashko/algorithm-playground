package com.algorithm.playground.leetcode.problems.lc800.lc814;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

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
