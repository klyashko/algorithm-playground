package com.leetcode.problems.depthfirstsearch.hard;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class LongestIncreasingPathInAMatrix {

	class Solution {

		private int[][] cache;

		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			int n = matrix.length;
			int m = matrix[0].length;
			cache = new int[n][m];
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(max, dfs(matrix, i, j));
				}
			}
			return max;
		}

		private int dfs(int[][] matrix, int r, int c) {
			if (cache[r][c] > 0) {
				return cache[r][c];
			}
			int len = 1;
			int max = len;
			int n = matrix.length;
			int m = matrix[0].length;
			int curr = matrix[r][c];

			if (r + 1 < n && matrix[r + 1][c] > curr) {
				max = Math.max(max, len + dfs(matrix, r + 1, c));
			}
			if (r - 1 >= 0 && matrix[r - 1][c] > curr) {
				max = Math.max(max, len + dfs(matrix, r - 1, c));
			}
			if (c + 1 < m && matrix[r][c + 1] > curr) {
				max = Math.max(max, len + dfs(matrix, r, c + 1));
			}
			if (c - 1 >= 0 && matrix[r][c - 1] > curr) {
				max = Math.max(max, len + dfs(matrix, r, c - 1));
			}
			cache[r][c] = max;
			return max;
		}
	}

}
