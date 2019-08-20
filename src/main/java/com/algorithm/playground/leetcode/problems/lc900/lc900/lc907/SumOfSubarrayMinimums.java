package com.algorithm.playground.leetcode.problems.lc900.lc900.lc907;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumOfSubarrayMinimums {

	class Solution {

		public int sumSubarrayMins(int[] A) {
			int[] stack = new int[A.length + 1];
			int top = 0, MOD = 1000000007, ans = 0;
			for (int right = 0; right <= A.length; right++) {
				int val = right == A.length ? 0 : A[right];

				while (top != 0 && A[stack[top]] > val) {
					int min = stack[top--];
					int left = top == 0 ? -1 : stack[top];
					ans += A[min] * (min - left) * (right - min);
					ans %= MOD;
				}
				stack[++top] = right;
			}
			return ans;
		}

	}

	class Solution_ {

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
