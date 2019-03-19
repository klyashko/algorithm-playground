package com.algorithm.playground.leetcode.problems.lc300.lc300.lc303;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class NumArray {

    private int[] sums;

    NumArray(int[] nums) {

        this.sums = new int[nums.length];

        if (sums.length == 0) {
            return;
        }
        sums[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }

}
