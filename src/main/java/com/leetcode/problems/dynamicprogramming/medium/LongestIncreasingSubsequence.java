package com.leetcode.problems.dynamicprogramming.medium;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

	class Solution {
		public int lengthOfLIS(int[] nums) {
			int min = Integer.MAX_VALUE, max = 0;
			for (int i = 0; i < nums.length; i++) {
				if (min > nums[i]) {
					max = Math.max(max, dfs(nums, i + 1));
					min = nums[i];
				}
			}
			return max;
		}

		private int dfs(int[] nums, int idx) {
			if (idx == nums.length) {
				return 1;
			}
			int min = Integer.MAX_VALUE, count = 0, curr = nums[idx - 1];
			for (int i = idx; i < nums.length; i++) {
				if (curr < nums[i] && min > nums[i]) {
					count = Math.max(count, dfs(nums, i + 1));
					min = nums[i];
				}
			}
			return count + 1;
		}
	}

}
