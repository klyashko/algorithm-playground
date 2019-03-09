package com.algorithm.playground.leetcode.problems.divideandconquer.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-permutations-for-di-sequence/description/
 */
public class ValidPermutationsForDISequence {

	class Solution {
		public int numPermsDISequence(String S) {
			int n = S.length(), mod = (int) 1e9 + 7;
			int[][] dp = new int[n + 1][n + 1];

			Arrays.fill(dp[0], 1);

			for (int i = 0; i < n; i++) {
				if (S.charAt(i) == 'I') {
					for (int j = 0, cur = 0; j < n - i; j++) {
						cur = (cur + dp[i][j]) % mod;
						dp[i + 1][j] = cur;
					}
				} else {
					for (int j = n - i - 1, cur = 0; j >= 0; j--) {
						cur = (cur + dp[i][j + 1]) % mod;
						dp[i + 1][j] = cur;
					}
				}
			}
			return dp[n][0];
		}
	}

}
