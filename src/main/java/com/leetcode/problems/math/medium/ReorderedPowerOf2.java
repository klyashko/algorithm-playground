package com.leetcode.problems.math.medium;

/**
 * https://leetcode.com/problems/reordered-power-of-2/description/
 */
public class ReorderedPowerOf2 {

	class Solution {
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

}
