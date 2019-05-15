package com.algorithm.playground.leetcode.problems.lc0.lc50.lc53;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
			int max = Integer.MIN_VALUE;
			int curr = 0;
			for (int i : nums) {
				curr = Math.max(i, curr + i);
				max = Math.max(max, curr);
            }
			return max;
        }
    }

}
