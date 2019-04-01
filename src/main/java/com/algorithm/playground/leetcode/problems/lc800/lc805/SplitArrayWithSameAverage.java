package com.algorithm.playground.leetcode.problems.lc800.lc805;

import java.util.*;

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
				if (size != A.length && sum / size == threshold) {
					return true;
				} else if (sum / size > threshold || size > A.length / 2 || idx == A.length) {
					return false;
				}
				boolean ans = testAllPermutations(A, sum + A[idx], size + 1, threshold, idx + 1);
				ans = ans || testAllPermutations(A, sum, size, threshold, idx + 1);
				return ans;
			});
		}

	}

	class DynamicProgrammingSolution {

		public boolean splitArraySameAverage(int[] A) {
			int len = A.length;
			int sum = 0;

			for (int i : A) {
				sum += i;
			}
			if (!isPossible(len, sum)) {
				return false;
			}

			int m = len / 2;

			List<Set<Integer>> sums = new ArrayList<>(m + 1);
			for (int i = 0; i <= m + 1; i++) {
				sums.add(new HashSet<>());
			}

			sums.get(0).add(0);

			for (int i : A) {
				for (int j = m; j >= 1; j--) {
					for (Integer t : sums.get(j - 1)) {
						int val = t + i;
						if (sum * j % len == 0 && val == sum * j / len) {
							return true;
						} else {
							sums.get(j).add(val);
						}
					}
				}
			}

			return false;
		}

		private boolean isPossible(int len, int sum) {
			for (int i = 1; i <= len / 2; i++) {
				if (sum * i % len == 0) {
					return true;
				}
			}
			return false;
		}

	}

}
