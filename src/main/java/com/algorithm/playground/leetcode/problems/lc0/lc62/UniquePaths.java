package com.algorithm.playground.leetcode.problems.lc0.lc62;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

	class Solution {

		public int uniquePaths(int m, int n) {
			int[] dp = new int[n + 1];
			Arrays.fill(dp, 1);
			dp[0] = 0;
			for (int i = 1; i < m; i++) {
				for (int j = 1; j <= n; j++) {
					dp[j] = dp[j - 1] + dp[j];
				}
			}
			return dp[dp.length - 1];
		}

	}

}
