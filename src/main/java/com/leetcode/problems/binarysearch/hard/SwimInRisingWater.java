package com.leetcode.problems.binarysearch.hard;

/**
 * https://leetcode.com/problems/swim-in-rising-water/description/
 */
public class SwimInRisingWater {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int swimInWater(int[][] grid) {
			int rows = grid.length;
			int cols = grid[0].length;
			return dfs(grid, new boolean[rows][cols], 0, 0, rows, cols);
		}

		private int dfs(int[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
			if (c < 0 || c == cols || r < 0 || r == rows || visited[r][c]) {
				return Integer.MAX_VALUE;
			}
			if (r + 1 == rows && c + 1 == cols) {
				return grid[r][c];
			}
			visited[r][c] = true;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				min = Math.min(min, dfs(grid, visited, r + dr[i], c + dc[i], rows, cols));
			}
			visited[r][c] = false;
			return Math.max(min, grid[r][c]);
		}
	}

}
