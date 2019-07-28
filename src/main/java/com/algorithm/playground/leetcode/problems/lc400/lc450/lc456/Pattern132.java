package com.algorithm.playground.leetcode.problems.lc400.lc450.lc456;

/**
 * https://leetcode.com/problems/132-pattern/
 * <p>
 * Given a sequence of n integers a1, a2, ..., an,
 * a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
 * Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 */
public class Pattern132 {

	class Solution {

		public boolean find132pattern(int[] nums) {
			if (nums.length < 3) {
				return false;
			}
			int[] stack = new int[nums.length + 1];
			int idx = 0;

			int[] mins = new int[nums.length];
			mins[0] = Integer.MAX_VALUE;

			for (int i = 0; i < nums.length; i++) {

				if (i != 0) {
					if (i == 1 || nums[i - 1] < mins[i - 1]) {
						mins[i] = nums[i - 1];
					} else {
						mins[i] = mins[i - 1];
					}
				}

				while (idx != 0 && nums[stack[idx]] <= nums[i]) {
					idx--;
				}

				if (idx != 0) {
					int min = mins[stack[idx]];
					if (min < nums[i]) {
						return true;
					}
				}
				stack[++idx] = i;
			}

			return false;
		}

	}

}
