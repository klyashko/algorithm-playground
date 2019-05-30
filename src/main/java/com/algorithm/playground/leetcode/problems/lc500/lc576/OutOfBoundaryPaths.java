package com.algorithm.playground.leetcode.problems.lc500.lc576;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 */
public class OutOfBoundaryPaths {

	class Solution {

		private final int[] DR = {0, 0, 1, -1};
		private final int[] DC = {1, -1, 0, 0};
		private final int MOD = (int) 1e9 + 7;

		public int findPaths(int m, int n, int N, int i, int j) {
			long[][][] dp = new long[m][n][N + 1];
			for (long[][] r : dp) {
				for (long[] rr : r) {
					Arrays.fill(rr, -1);
				}
			}
			return (int) (dp(m, n, N, i, j, dp) % MOD);
		}

		private long dp(int m, int n, int N, int r, int c, long[][][] cache) {
			if (r < 0 || c < 0 || r == m || c == n) {
				return 1;
			} else if (N == 0) {
				return 0;
			} else if (cache[r][c][N] != -1) {
				return cache[r][c][N];
			} else {
				long count = 0;
				for (int i = 0; i < 4; i++) {
					count += dp(m, n, N - 1, r + DR[i], c + DC[i], cache);
				}
				return cache[r][c][N] = count % MOD;
			}
		}

	}

}
