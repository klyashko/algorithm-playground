package com.leetcode.problems.unionfind.hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/bricks-falling-when-hit/description/
 */
public class BricksFallingWhenHit {

	class Solution {

		private final int[] dr = new int[]{-1, 1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		private Map<Integer, List<Integer>> map = new HashMap<>();

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int rows = grid.length;
			return null;
		}

		private int[] point(int key, int cols) {
			return new int[]{key / cols, key % cols};
		}

		private int key(int r, int c, int cols) {
			return r * cols + c;
		}


	}

	class Solution_ {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < ans.length; i++) {
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				boolean[][] visited = new boolean[rows][cols];
				for (int c = 0; c < cols; c++) {
					dfs(grid, visited, 0, c);
				}
				int count = 0;
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						if (grid[r][c] == 1 && !visited[r][c]) {
							grid[r][c] = 0;
							count++;
						}
					}
				}
				ans[i] = count;
			}
			return ans;
		}

		private void dfs(int[][] grid, boolean[][] visited, int r, int c) {
			if (visited[r][c] || grid[r][c] == 0) {
				return;
			}
			visited[r][c] = true;
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
					dfs(grid, visited, tr, tc);
				}
			}
		}
	}

}
