package com.algorithm.playground.leetcode.problems.lc300.lc320.lc329;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 */
public class LongestIncreasingPathInAMatrix {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int longestIncreasingPath(int[][] matrix) {
			if (matrix.length == 0) {
				return 0;
			}
			int n = matrix.length;
			int m = matrix[0].length;
			int[][] cache = new int[n][m];
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(max, dfs(matrix, i, j, cache));
				}
			}
			return max;
		}

		private int dfs(int[][] matrix, int r, int c, int[][] cache) {
			if (cache[r][c] > 0) {
				return cache[r][c];
			}
			int len = 1;
			int max = len;
			int n = matrix.length;
			int m = matrix[0].length;
			int curr = matrix[r][c];

			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr < n && tr >= 0 && tc < m && tc >= 0 && matrix[tr][tc] > curr) {
					max = Math.max(max, len + dfs(matrix, tr, tc, cache));
				}
			}

			cache[r][c] = max;
			return max;
		}
	}

}
