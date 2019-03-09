package com.algorithm.playground.leetcode.problems.divideandconquer.hard;

/**
 * https://leetcode.com/problems/burst-balloons/description/
 */
public class BurstBalloons {

	class Solution {
		public int maxCoins(int[] nums) {
			if (nums.length == 0) {
				return 0;
			}
			int[][] T = new int[nums.length][nums.length];
			for (int len = 1; len <= nums.length; len++) {
				for (int i = 0; i <= nums.length - len; i++) {
					int j = i + len - 1;
					for (int k = i; k <= j; k++) {
						int left = i != 0 ? nums[i - 1] : 1;
						int right = j != nums.length - 1 ? nums[j + 1] : 1;

						int before = i != k ? T[i][k - 1] : 0;
						int after = j != k ? T[k + 1][j] : 0;

						T[i][j] = Math.max(left * nums[k] * right + before + after, T[i][j]);
					}
				}
			}
			return T[0][nums.length - 1];
		}
	}

}
