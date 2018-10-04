package com.leetcode.problems.random.medium;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 */
public class ImplementRand10UsingRand7 {

	class Solution extends SolBase {

		private int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		private int idx = 0;

		public int rand10() {
			idx = (idx + rand7()) % nums.length;
			return nums[idx];
		}
	}

}
