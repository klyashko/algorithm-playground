package com.algorithm.playground.leetcode.problems.lc700.lc780.lc786;

/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
 */
public class KthSmallestPrimeFraction {

	class Solution {
		public int[] kthSmallestPrimeFraction(int[] A, int K) {
			double l = 0, r = 1;
			int p = 0, q = 1;

			for (int n = A.length, cnt = 0; true; cnt = 0, p = 0) {
				double m = (l + r) / 2;

				for (int i = 0, j = n - 1; i < n; i++) {
					while (j >= 0 && A[i] > m * A[n - 1 - j]) {
						j--;
					}
					cnt += (j + 1);

					if (j >= 0 && p * A[n - 1 - j] < q * A[i]) {
						p = A[i];
						q = A[n - 1 - j];
					}
				}

				if (cnt < K) {
					l = m;
				} else if (cnt > K) {
					r = m;
				} else {
					return new int[]{p, q};
				}
			}
		}
	}

}
