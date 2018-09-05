package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {

	class Solution {
		public TreeNode constructMaximumBinaryTree(int[] nums) {
			return createNode(nums, 0, nums.length);
		}

		private TreeNode createNode(int[] nums, int left, int right) {
			if (left == right) {
				return null;
			}
			int idx = left;
			for (int i = left + 1; i < right; i++) {
				if (nums[i] > nums[idx]) {
					idx = i;
				}
			}
			TreeNode node = new TreeNode(nums[idx]);
			node.left = createNode(nums, left, idx);
			node.right = createNode(nums, idx + 1, right);
			return node;
		}
	}

}
