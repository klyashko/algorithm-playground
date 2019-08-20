package com.algorithm.playground.leetcode.problems.lc900.lc900.lc907;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumOfSubarrayMinimums {

	class Solution {

		public int sumSubarrayMins(int[] A) {
			return (int) sumSubarrayMins(A, 0, A.length);
		}

		private long sumSubarrayMins(int[] A, int left, int right) {
			if (left >= right) {
				return 0;
			}
			int min = left;
			for (int i = left; i < right; i++) {
				if (A[i] < A[min]) {
					min = i;
				}
			}
			int MOD = 1000000007;
			long curr = ((min - left + 1) * (right - min) * A[min]) % MOD;
			return (curr + sumSubarrayMins(A, left, min) + sumSubarrayMins(A, min + 1, right)) % MOD;
		}

	}

}
