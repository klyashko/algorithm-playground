package com.leetcode.problems.lc200.lc222;

import com.leetcode.problems.tree.TreeNode;

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
