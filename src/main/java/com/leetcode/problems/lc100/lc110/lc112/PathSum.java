package com.leetcode.problems.lc100.lc110.lc112;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {

	class Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null) {
				return false;
			}
			sum -= root.val;
			if (sum == 0 && root.left == null && root.right == null) {
				return true;
			}
			return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		}
	}

}
