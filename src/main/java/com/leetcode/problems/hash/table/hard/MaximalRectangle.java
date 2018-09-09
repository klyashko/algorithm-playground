package com.leetcode.problems.hash.table.hard;

/**
 * https://leetcode.com/problems/maximal-rectangle/description/
 */
public class MaximalRectangle {

	class Solution {
		public int maximalRectangle(char[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			int n = matrix.length;
			int m = matrix[0].length;
			int[] heights = new int[m];

			for (int i = 0; i < m; i++) {
				heights[i] = matrix[0][i] - '0';
			}

			int max = getMax(heights);

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int curr = matrix[i][j] - '0';
					heights[j] = curr * heights[j] + curr;
				}
				max = Math.max(max, getMax(heights));
			}

			return max;
		}

		private int getMax(int[] heights) {
			int max = 0;
			for (int i = 0; i < heights.length; i++) {
				if (heights[i] != 0) {
					for (int j = heights[i]; j > 0; j--) {
						int w = 1;
						for (; w + i < heights.length; w++) {
							if (heights[i + w] < j) {
								break;
							}
						}
						max = Math.max(max, j * w);
					}
				}
			}
			return max;
		}
	}

	class SlowSolution {
		public int maximalRectangle(char[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			int n = matrix.length;
			int m = matrix[0].length;
			int[][] horizontal = new int[n][m];
			int[][] vertical = new int[n][m];

			for (int i = n - 1; i >= 0; i--) {
				int curr = matrix[i][m - 1] - '0';
				horizontal[i][m - 1] = curr;
				if (i == n - 1) {
					vertical[i][m - 1] = curr;
				} else {
					vertical[i][m - 1] = curr * vertical[i + 1][m - 1] + curr;
				}
			}

			for (int i = m - 1; i >= 0; i--) {
				int curr = matrix[n - 1][i] - '0';
				vertical[n - 1][i] = curr;
				if (i == m - 1) {
					horizontal[n - 1][i] = curr;
				} else {
					horizontal[n - 1][i] = curr * horizontal[n - 1][i + 1] + curr;
				}
			}

			for (int i = n - 2; i >= 0; i--) {
				for (int j = m - 2; j >= 0; j--) {
					int curr = matrix[i][j] - '0';
					horizontal[i][j] = curr * horizontal[i][j + 1] + curr;
					vertical[i][j] = curr * vertical[i + 1][j] + curr;
				}
			}

			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int h = horizontal[i][j];
					int v = vertical[i][j];
					for (int th = h; th > 0 && th * v > max; th--) {
						for (int tv = v; tv > 0 && th * tv > max; tv--) {
							boolean valid = true;

							for (int g = tv - 1; g >= 0; g--) {
								if (horizontal[i + g][j] < th) {
									valid = false;
									break;
								}
							}

							for (int g = th - 1; g >= 0 && valid; g--) {
								if (vertical[i][j + g] < tv) {
									valid = false;
								}
							}

							if (valid) {
								max = th * tv;
								break;
							}
						}
					}
				}
			}

			return max;
		}
	}

}
