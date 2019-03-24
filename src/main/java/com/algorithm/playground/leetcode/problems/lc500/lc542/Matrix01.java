package com.algorithm.playground.leetcode.problems.lc500.lc542;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/01-matrix/
 */
@SuppressWarnings("Duplicates")
public class Matrix01 {

	class Solution {

		public int[][] updateMatrix(int[][] matrix) {
			int rows = matrix.length;
			int cols = matrix[0].length;
			int[][] ans = new int[rows][cols];
			for (int[] row : ans) {
				Arrays.fill(row, Integer.MAX_VALUE / 2);
			}
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (matrix[r][c] == 0) {
						ans[r][c] = 0;
					} else {
						if (r > 0) {
							ans[r][c] = Math.min(ans[r][c], ans[r - 1][c] + 1);
						}
						if (c > 0) {
							ans[r][c] = Math.min(ans[r][c], ans[r][c - 1] + 1);
						}
					}
				}
			}

			for (int r = rows - 1; r >= 0; r--) {
				for (int c = cols - 1; c >= 0; c--) {
					if (r < rows - 1) {
						ans[r][c] = Math.min(ans[r][c], ans[r + 1][c] + 1);
					}
					if (c < cols - 1) {
						ans[r][c] = Math.min(ans[r][c], ans[r][c + 1] + 1);
					}
				}
			}

			return ans;
		}

	}

	class DFSSolution {

		private final int[] dr = {1, -1, 0, 0};
		private final int[] dc = {0, 0, 1, -1};

		public int[][] updateMatrix(int[][] matrix) {
			int rows = matrix.length;
			int cols = matrix[0].length;
			int[][] ans = new int[rows][cols];
			for (int[] row : ans) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (matrix[r][c] == 0) {
						dfs(matrix, ans, r, c, rows, cols, 0);
					}
				}
			}
			return ans;
		}

		private void dfs(int[][] matrix, int[][] values, int r, int c, int rows, int cols, int dist) {
			if (isNotInMatrix(r, rows) || isNotInMatrix(c, cols) || values[r][c] <= dist) {
				return;
			}
			dist = matrix[r][c] == 0 ? 0 : dist;
			values[r][c] = dist;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i];
				int tc = c + dc[i];
				dfs(matrix, values, tr, tc, rows, cols, dist + 1);
			}
		}

		private boolean isNotInMatrix(int i, int limit) {
			return i < 0 || i >= limit;
		}

	}

}
