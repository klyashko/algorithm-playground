package com.leetcode.problems.dynamicprogramming.easy;

/**
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }

            int[] res = new int[nums.length];

            res[0] = nums[0];
            res[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
            }

            return res[res.length - 1];
        }
    }

}
