package com.algorithm.playground.leetcode.problems.lc600.lc670.lc674;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class LongestContinuousIncreasingSubsequence {

	class Solution {
		public int findLengthOfLCIS(int[] nums) {
			if (nums.length == 0) {
				return 0;
			}
			int prev = Integer.MAX_VALUE;
			int count = 0, max = 0;
			for (int i : nums) {
				if (i > prev) {
					count++;
				} else {
					max = Math.max(max, count);
					count = 1;
				}
				prev = i;
			}
			return Math.max(max, count);
		}
	}

}
