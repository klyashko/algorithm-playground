package com.algorithm.playground.leetcode.problems.lc500.lc561;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/description/
 */
public class Solution {

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += Math.min(nums[i], nums[i + 1]);
		}
		return sum;
	}

}
