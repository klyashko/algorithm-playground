package com.algorithm.playground.leetcode.problems.lc0.lc53;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {

    class Solution {

        public int maxSubArray(int[] nums) {
            int cur = nums[0];
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                cur = Math.max(nums[i], cur + nums[i]);
                res = Math.max(res, cur);
            }
            return res;
        }

    }

}
