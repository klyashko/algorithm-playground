package com.leetcode.problems.math.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/split-array-with-same-average/description/
 */
public class SplitArrayWithSameAverage {

	class Solution {

		private Map<String, Boolean> cache = new HashMap<>();

		public boolean splitArraySameAverage(int[] A) {
			if (A.length == 0) {
				return true;
			}

			double sum = 0;
			for (int i : A) {
				sum += i;
			}

			Arrays.sort(A);
			return testAllPermutations(A, 0., 0, sum / A.length, 0);
		}

		private boolean testAllPermutations(int[] A, double sum, int size, double threshold, int idx) {
			if (sum / size > threshold) {
				return false;
			} else if (size != A.length && sum / size == threshold) {
				return true;
			} else if (idx == A.length) {
				return size != A.length && sum / size == threshold;
			}

			boolean ans = testAllPermutations(A, sum, size, threshold, idx + 1);
			if (sum / size != sum + A[idx] / (size + 1)) {
				ans = ans || testAllPermutations(A, sum + A[idx], size + 1, threshold, idx + 1);
			}

//			boolean ans = testAllPermutations(A, sum + A[idx], size + 1, threshold, idx + 1);
//			ans = ans || testAllPermutations(A, sum, size, threshold, idx + 1);
			return ans;
		}

	}

}
