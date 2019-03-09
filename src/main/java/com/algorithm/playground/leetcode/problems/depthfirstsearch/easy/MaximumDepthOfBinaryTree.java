package com.algorithm.playground.leetcode.problems.depthfirstsearch.easy;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {

	class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}

}
