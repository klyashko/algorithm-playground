package com.algorithm.playground.leetcode.problems.math.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reordered-power-of-2/description/
 */
public class ReorderedPowerOf2 {

	class PermutationSolution {
		public boolean reorderedPowerOf2(int N) {
			String s = String.valueOf(N);
			return testAllPermutation(s.toCharArray(), 0);
		}

		private boolean testAllPermutation(char[] digits, int idx) {
			if (digits[0] == '0') {
				return false;
			}
			if (idx == digits.length - 1) {
				int i = Integer.valueOf(String.valueOf(digits));
				return (i & (i - 1)) == 0;
			}
			for (int i = idx; i < digits.length; i++) {
				swap(digits, idx, i);

				if (testAllPermutation(digits, idx + 1)) {
					return true;
				}

				swap(digits, idx, i);
			}
			return false;
		}

		private void swap(char[] digits, int i1, int i2) {
			char t = digits[i1];
			digits[i1] = digits[i2];
			digits[i2] = t;
		}
	}

	class Solution {
		public boolean reorderedPowerOf2(int N) {
			int[] counts = countDigits(N);
			for (int i = 0; i < 31; i++) {
				if (Arrays.equals(counts, countDigits(1 << i))) {
					return true;
				}
			}
			return false;
		}

		private int[] countDigits(int N) {
			int[] counts = new int[10];

			while (N != 0) {
				counts[N % 10]++;
				N /= 10;
			}
			return counts;
		}
	}

}
