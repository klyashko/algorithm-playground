package com.algorithm.playground.leetcode.problems.binarysearch.hard;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 */
public class MaxSumOfRectangleNoLargerThanK {

	class Solution {
		public int maxSumSubmatrix(int[][] matrix, int k) {
			if (matrix.length == 0) {
				return 0;
			}
			int rows = matrix.length;
			int cols = matrix[0].length;
			int max = Integer.MIN_VALUE;
			for (int l = 0; l < cols; l++) {
				int[] row = new int[rows];
				for (int r = l; r < cols; r++) {
					for (int i = 0; i < rows; i++) {
						row[i] += matrix[i][r];
					}
					max = Math.max(max, max(row, k));
				}
			}
			return max;
		}

		private int max(int[] row, int bound) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < row.length; i++) {
				int tmp = 0;
				for (int j = i; j < row.length; j++) {
					tmp += row[j];
					if (tmp <= bound) {
						max = Math.max(max, tmp);
					}
				}
			}
			return max;
		}
	}

}
