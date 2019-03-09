package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium;

/**
 * https://leetcode.com/problems/arithmetic-slices/description/
 */
public class ArithmeticSlices {

	class Solution {

		public int numberOfArithmeticSlices(int[] A) {
			if (A.length < 3) {
				return 0;
			}
			int diff = A[0] - A[1];
			int rez = 0;
			int count = 2;

			for (int i = 2; i < A.length; i++) {
				int currentDiff = A[i - 1] - A[i];
				if (currentDiff != diff) {
					rez += countOptions(count);
					count = 1;
					diff = currentDiff;
				}
				count++;
			}
			rez += countOptions(count);
			return rez;
		}

		private int countOptions(int i) {
			if (i < 3) {
				return 0;
			} else {
				int res = 0;
				for (int j = 3; j <= i; j++) {
					res += (i - j + 1);
				}
				return res;
			}
		}
	}

}
