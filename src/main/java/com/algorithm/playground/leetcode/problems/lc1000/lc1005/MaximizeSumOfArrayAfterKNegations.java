package com.algorithm.playground.leetcode.problems.lc1000.lc1005;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class MaximizeSumOfArrayAfterKNegations {

	class Solution {
		public int largestSumAfterKNegations(int[] A, int K) {
			Arrays.sort(A);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < A.length && K > 0; i++) {
				if (A[i] < 0) {
					A[i] = -A[i];
					K--;
					min = Math.min(min, A[i]);
				} else {
					min = Math.min(min, A[i]);
					break;
				}
			}

			int sum = 0;
			for (int i : A) {
				sum += i;
			}

			return (K & 1) == 0 ? sum : sum - (min << 1);
		}
	}

}
