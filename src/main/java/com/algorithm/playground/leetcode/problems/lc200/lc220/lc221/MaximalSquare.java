package com.algorithm.playground.leetcode.problems.lc200.lc220.lc221;

/**
 * https://leetcode.com/problems/maximal-square/
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {

	class Solution {

		public int maximalSquare(char[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			int rows = matrix.length;
			int cols = matrix[0].length;
			int[][] index = new int[rows][cols];

			for (int c = 0; c < cols; c++) {
				index[0][c] = matrix[0][c] - '0';
			}

			for (int r = 1; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (matrix[r][c] == '1') {
						index[r][c] = index[r - 1][c] + 1;
					}
				}
			}

			int max = -1;
			for (int r = rows - 1; r >= 0 && r >= max; r--) {
				for (int c = 0; c < cols && cols - c > max; c++) {
					int side = Math.min(index[r][c], cols - c);
					if (side > max) {
						for (int i = 0; i < side; i++) {
							int idx = i + c;
							if (index[r][idx] == 0) {
								side = i;
							} else {
								side = Math.min(side, index[r][idx]);
							}
						}
						max = Math.max(max, side);
					}
				}
			}

			return max * max;
		}

	}

}
