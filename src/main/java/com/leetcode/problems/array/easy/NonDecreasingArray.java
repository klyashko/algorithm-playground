package com.leetcode.problems.array.easy;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {

	class Solution {
		public boolean checkPossibility(int[] nums) {
			int max = Integer.MIN_VALUE;
			boolean error = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					if (error) {
						return false;
					}
					error = true;
					if (nums[i + 1] < max) {
						nums[i + 1] = nums[i];
					} else {
						nums[i] = nums[i + 1];
					}
				}
				max = nums[i];
			}
			return true;
		}
	}

}
