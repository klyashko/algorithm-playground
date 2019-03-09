package com.algorithm.playground.leetcode.problems.depthfirstsearch.easy;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int maxAreaOfIsland(int[][] grid) {
			if (grid.length == 0) {
				return 0;
			}
			int n = grid.length;
			int m = grid[0].length;

			int max = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(max, dfs(grid, i, j));
				}
			}

			return max;
		}

		private int dfs(int[][] grid, int r, int c) {
			if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0) {
				return 0;
			}
			grid[r][c] = 0;
			int aria = 1;
			for (int i = 0; i < 4; i++) {
				aria += dfs(grid, r + dr[i], c + dc[i]);
			}
			return aria;
		}

	}

}
