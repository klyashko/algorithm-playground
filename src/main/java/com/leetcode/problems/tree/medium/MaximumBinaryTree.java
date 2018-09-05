package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {

	class Solution {
		public TreeNode constructMaximumBinaryTree(int[] nums) {
			return createNode(nums, 0, nums.length - 1);
		}

		private TreeNode createNode(int[] nums, int left, int right) {
			if (left > right) {
				return null;
			}
			int idx = left;
			int max = nums[left];
			for (int i = left + 1; i <= right; i++) {
				if (nums[i] > max) {
					max = nums[i];
					idx = i;
				}
			}
			TreeNode node = new TreeNode(max);
			node.left = createNode(nums, left, idx - 1);
			node.right = createNode(nums, idx + 1, right);
			return node;
		}
	}

}
