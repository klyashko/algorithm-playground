package com.leetcode.problems.stack.medium;

/**
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class NextGreaterElementII {

	class Solution {
		public int[] nextGreaterElements(int[] nums) {
			int[] ans = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				ans[i] = -1;
				for (int j = (i + 1) % nums.length; j != i; j = (j + 1) % nums.length) {
					if (nums[j] > nums[i]) {
						ans[i] = nums[j];
						break;
					}
				}
			}
			return ans;
		}
	}

}
