package com.algorithm.playground.leetcode.problems.lc200.lc220.lc222;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

	class Solution {
		public int countNodes(TreeNode root) {
			return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

}
