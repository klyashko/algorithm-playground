package com.algorithm.playground.leetcode.problems.lc100.lc130.lc130;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

	class Solution {

		private final int[] dr = {1, -1, 0, 0};
		private final int[] dc = {0, 0, 1, -1};

		public void solve(char[][] board) {
			if (board.length == 0) {
				return;
			}
			int rows = board.length;
			int cols = board[0].length;
			boolean[][] visited = new boolean[rows][cols];

			for (int r = 0; r < rows; r++) {
				dfs(board, visited, r, 0, rows, cols);
				dfs(board, visited, r, cols - 1, rows, cols);
			}
			for (int c = 0; c < cols; c++) {
				dfs(board, visited, 0, c, rows, cols);
				dfs(board, visited, rows - 1, c, rows, cols);
			}

			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (!visited[r][c]) {
						board[r][c] = 'X';
					}
				}
			}
		}

		private void dfs(char[][] board, boolean[][] visited, int r, int c, int rows, int cols) {
			if (isNotInRange(r, rows) || isNotInRange(c, cols) || visited[r][c] || board[r][c] == 'X') {
				return;
			}
			visited[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i];
				int tc = c + dc[i];
				dfs(board, visited, tr, tc, rows, cols);
			}
		}

		private boolean isNotInRange(int n, int to) {
			return n < 0 || n >= to;
		}

	}

}
