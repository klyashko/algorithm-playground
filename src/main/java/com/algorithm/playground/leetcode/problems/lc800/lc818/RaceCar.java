package com.algorithm.playground.leetcode.problems.lc800.lc818;

/**
 * https://leetcode.com/problems/race-car/description/
 */
public class RaceCar {

	class Solution {
		int[] dp = new int[10001];

		public int racecar(int t) {
			if (dp[t] > 0) {
				return dp[t];
			}
			int n = (int) (Math.log(t) / Math.log(2)) + 1;
			if (1 << n == t + 1) {
				dp[t] = n;
			} else {
				dp[t] = racecar((1 << n) - 1 - t) + n + 1;
				for (int m = 0; m < n - 1; ++m) {
					dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
				}
			}
			return dp[t];
		}
	}

}
