package com.algorithm.playground.leetcode.problems.lc300.lc300.lc300;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

	class Solution {
		public int lengthOfLIS(int[] nums) {
			int min = Integer.MAX_VALUE, max = 0;
			int[] cache = new int[nums.length];
			Arrays.fill(cache, -1);
			for (int i = 0; i < nums.length; i++) {
				if (min > nums[i]) {
					max = Math.max(max, dfs(nums, i + 1, cache));
					min = nums[i];
				}
			}
			return max;
		}

		private int dfs(int[] nums, int idx, int[] cache) {
			if (idx == nums.length) {
				return 1;
			} else if (cache[idx] == -1) {
				int min = Integer.MAX_VALUE, count = 0, curr = nums[idx - 1];
				for (int i = idx; i < nums.length; i++) {
					if (curr < nums[i] && min > nums[i]) {
						count = Math.max(count, dfs(nums, i + 1, cache));
						min = nums[i];
					}
				}
				cache[idx] = count + 1;
			}

			return cache[idx];
		}
	}

}
