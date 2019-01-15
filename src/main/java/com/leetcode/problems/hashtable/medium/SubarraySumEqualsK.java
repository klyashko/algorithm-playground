package com.leetcode.problems.hashtable.medium;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {

	class Solution {
		public int subarraySum(int[] nums, int k) {
			int[] col = new int[nums.length];

			int count = 0;
			for (int c = 0; c < nums.length; c++) {
				for (int r = 0; r <= c; r++) {
					col[r] = col[r] + nums[c];
					if (col[r] == k) {
						count++;
					}
				}
			}

			return count;
		}
	}

}
