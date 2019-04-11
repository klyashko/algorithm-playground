package com.algorithm.playground.leetcode.problems.lc600.lc670.lc670;

/**
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class MaximumSwap {

	class Solution {
		public int maximumSwap(int num) {
			int[] digits = toDigits(num);

			for (int i = 0; i < digits.length; i++) {
				int max = digits[i];
				int idx = i;

				for (int j = i + 1; j < digits.length; j++) {
					if (digits[j] > max || (digits[j] == max && idx != i)) {
						max = digits[j];
						idx = j;
					}
				}
				if (idx != i) {
					int t = digits[i];
					digits[i] = digits[idx];
					digits[idx] = t;
					break;
				}
			}


			return toInteger(digits);
		}

		private int toInteger(int[] digits) {
			int n = digits[0];
			for (int i = 1; i < digits.length; i++) {
				n *= 10;
				n += digits[i];
			}
			return n;
		}

		private int[] toDigits(int n) {
			int[] digits = new int[numberOfDigits(n)];
			for (int i = digits.length - 1; i >= 0; i--) {
				digits[i] = n % 10;
				n /= 10;
			}

			return digits;
		}

		private int numberOfDigits(int n) {
			if (n >= 100000000) {
				return 8 + numberOfDigits(n / 100000000);
			} else if (n >= 10000) {
				return 4 + numberOfDigits(n / 10000);
			} else if (n >= 100) {
				return 2 + numberOfDigits(n / 100);
			} else if (n >= 10) {
				return 2;
			}
			return 1;
		}
	}

}
