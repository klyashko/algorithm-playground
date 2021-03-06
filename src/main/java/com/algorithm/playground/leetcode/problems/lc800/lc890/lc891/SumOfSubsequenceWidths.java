package com.algorithm.playground.leetcode.problems.lc800.lc890.lc891;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-subsequence-widths/description/
 */
public class SumOfSubsequenceWidths {

	class Solution {
		public int sumSubseqWidths(int[] A) {
			int mod = 1_000_000_007;
			Arrays.sort(A);
			long ans = 0;
			long c = 1;
			int n = A.length;
			for (int i = 0; i < n; i++, c = (c << 1) % mod) {
				ans += A[i] * c;
				ans -= A[n - i - 1] * c;
				ans = ans % mod;
			}
			return (int) ans;
		}
	}

}
