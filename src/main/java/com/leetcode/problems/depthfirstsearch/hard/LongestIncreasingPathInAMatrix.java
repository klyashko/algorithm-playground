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
			boolean[][] seen = new boolean[n][m];
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(max, dfs(matrix, seen, i, j, 1));
				}
			}
			return max;
		}

		private int dfs(int[][] matrix, boolean[][] seen, int r, int c, int len) {
			if (cache[r][c] > 0) {
				return cache[r][c];
			}
			int max = len;
			int n = matrix.length;
			int m = matrix[0].length;
			int curr = matrix[r][c];

			if (r + 1 < n && matrix[r + 1][c] > curr) {
				max = Math.max(max, dfs(matrix, seen, r + 1, c, len + 1));
			}
			if (r - 1 >= 0 && matrix[r - 1][c] > curr) {
				max = Math.max(max, dfs(matrix, seen, r - 1, c, len + 1));
			}
			if (c + 1 < m && matrix[r][c + 1] > curr) {
				max = Math.max(max, dfs(matrix, seen, r, c + 1, len + 1));
			}
			if (c - 1 >= 0 && matrix[r][c - 1] > curr) {
				max = Math.max(max, dfs(matrix, seen, r, c - 1, len + 1));
			}
			cache[r][c] = max;
			return max;
		}
	}

}
