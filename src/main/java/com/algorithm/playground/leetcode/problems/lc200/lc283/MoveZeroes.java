package com.algorithm.playground.leetcode.problems.lc200.lc283;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 */
public class MoveZeroes {

	class Solution {
		public void moveZeroes(int[] nums) {
			int zeros = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					zeros++;
				} else {
					nums[i - zeros] = nums[i];
				}
			}
			for (int i = zeros; i > 0; i--) {
				nums[nums.length - i] = 0;
			}
		}
	}

}
