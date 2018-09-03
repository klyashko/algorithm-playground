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
			double sum = 0;
			for (int i : A) {
				sum += i;
			}

			if (!isPossible(A.length, sum)) {
				return false;
			}

			Arrays.sort(A);
			return testAllPermutations(A, 0., 0, sum / A.length, 0);
		}

		private boolean isPossible(int len, double sum) {
			for (int i = 1; i <= len / 2; i++) {
				if (sum * i % len == 0) {
					return true;
				}
			}
			return false;
		}

		private boolean testAllPermutations(int[] A, double sum, int size, double threshold, int idx) {
			String key = String.format("%s_%s_%s", sum, size, idx);
			return cache.computeIfAbsent(key, ignored -> {
				if (size > A.length / 2) {
					return size != A.length && sum / size == threshold;
				} else if (sum / size > threshold) {
					return false;
				} else if (size != A.length && sum / size == threshold) {
					return true;
				} else if (idx == A.length) {
					return size != A.length && sum / size == threshold;
				}

				boolean ans = testAllPermutations(A, sum + A[idx], size + 1, threshold, idx + 1);
				ans = ans || testAllPermutations(A, sum, size, threshold, idx + 1);
				return ans;
			});
		}

	}

}
