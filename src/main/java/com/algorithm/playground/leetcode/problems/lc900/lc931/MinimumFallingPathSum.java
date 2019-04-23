package com.algorithm.playground.leetcode.problems.lc900.lc931;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 * <p>
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 * <p>
 * A falling path starts at any element in the first row, and chooses one element from each row.
 * The next row's choice must be in a column that is different from the previous row's column by at most one.
 */
public class MinimumFallingPathSum {

	class Solution {

		public int minFallingPathSum(int[][] A) {
			int[] prev = new int[A[0].length];
			int[] dp = new int[A[0].length];
			for (int[] row : A) {
				for (int i = 0; i < dp.length; i++) {
					dp[i] = row[i] + prev[i];
					if (i > 0) {
						dp[i] = Math.min(dp[i], row[i] + prev[i - 1]);
					}
					if (i + 1 < dp.length) {
						dp[i] = Math.min(dp[i], row[i] + prev[i + 1]);
					}
				}
				prev = Arrays.copyOf(dp, dp.length);
			}
			int min = Integer.MAX_VALUE;
			for (int i : dp) {
				min = Math.min(i, min);
			}
			return min;
		}

	}

}
