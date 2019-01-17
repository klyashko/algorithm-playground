package com.leetcode.problems.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

	class Solution {

		private final int[] dr = new int[]{1, 0};
		private final int[] dc = new int[]{0, 1};

		public int minPathSum(int[][] grid) {
			if (grid.length == 0) {
				return 0;
			}
			int[][] cache = new int[grid.length][grid[0].length];
			for (int[] row : cache) {
				Arrays.fill(row, Integer.MAX_VALUE);
			}
			dfs(0, 0, cache, grid, grid[0][0]);
			return cache[grid.length - 1][grid[0].length - 1];
		}

		private void dfs(int r, int c, int[][] cache, int[][] grid, int sum) {
			if (sum >= cache[r][c]) {
				return;
			}
			cache[r][c] = sum;
			if (r == grid.length - 1 && c == grid[0].length - 1) {
				return;
			}
			int n = grid.length;
			int m = grid[0].length;
			for (int i = 0; i < 2; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr >= 0 && tr < n && tc >= 0 && tc < m) {
					dfs(tr, tc, cache, grid, sum + grid[tr][tc]);
				}
			}
		}
	}

}
