package com.leetcode.problems.array.easy;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

	class Solution {
		public int missingNumber(int[] nums) {
			int expect = ((nums.length + 1) * nums.length) / 2;
			int sum = 0;
			for (int i : nums) {
				sum += i;
			}
			return expect - sum;
		}
	}

}
