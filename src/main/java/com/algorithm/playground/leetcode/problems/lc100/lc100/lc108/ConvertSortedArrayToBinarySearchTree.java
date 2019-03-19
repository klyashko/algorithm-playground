package com.algorithm.playground.leetcode.problems.lc100.lc100.lc108;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

	class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			return nums.length == 0 ? null : sortedArrayToBST(nums, 0, nums.length - 1);
		}

		private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
			if (from > to) {
				return null;
			}
			int mid = (to - from) / 2 + from;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = sortedArrayToBST(nums, from, mid - 1);
			node.right = sortedArrayToBST(nums, mid + 1, to);
			return node;
		}

	}

}
