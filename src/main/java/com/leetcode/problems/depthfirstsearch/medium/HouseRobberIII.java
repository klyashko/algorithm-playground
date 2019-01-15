package com.leetcode.problems.depthfirstsearch.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {

	class Solution {

		public int rob(TreeNode root) {
			int[] res = dfs(root);
			return Math.max(res[0], res[1]);
		}

		private int[] dfs(TreeNode node) {
			if (node == null) {
				return new int[2];
			}
			int[] l = dfs(node.left);
			int[] r = dfs(node.right);

			int[] res = new int[2];
			res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
			res[1] = l[0] + r[0] + node.val;
			return res;
		}

	}

}
