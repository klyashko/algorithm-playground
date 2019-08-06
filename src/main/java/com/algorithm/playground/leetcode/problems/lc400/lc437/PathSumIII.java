package com.algorithm.playground.leetcode.problems.lc400.lc437;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {

		public int pathSum(TreeNode root, int sum) {
			if (root == null) {
				return 0;
			}
			return countPath(root, -sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
		}

		private int countPath(TreeNode node, int curr) {
			int count = 0;
			if (node != null) {
				curr += node.val;
				if (curr == 0) {
					count = 1;
				}
				return count + countPath(node.left, curr) + countPath(node.right, curr);
			}
			return count;
		}

	}

}
