package com.leetcode.problems.depthfirstsearch.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {

	class Solution {

		public int rob(TreeNode root) {
			return Math.max(include(root), exclude(root));
		}

		private int include(TreeNode node) {
			if (node == null) {
				return 0;
			}
			return exclude(node.left) + exclude(node.right) + node.val;
		}

		private int exclude(TreeNode node) {
			if (node == null) {
				return 0;
			}
			return rob(node.left) + rob(node.right);
		}

	}


}
