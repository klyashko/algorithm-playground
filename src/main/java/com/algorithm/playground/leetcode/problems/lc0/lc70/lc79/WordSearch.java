package com.algorithm.playground.leetcode.problems.lc0.lc70.lc79;

/**
 * https://leetcode.com/problems/word-search/
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {

	class Solution {

		private final int[] DR = {1, -1, 0, 0};
		private final int[] DC = {0, 0, 1, -1};

		public boolean exist(char[][] board, String word) {
			if (board.length == 0) {
				return false;
			}
			int rows = board.length;
			int cols = board[0].length;
			char[] chars = word.toCharArray();
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (dfs(board, r, c, chars, 0)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean dfs(char[][] board, int r, int c, char[] word, int idx) {
			if (board[r][c] == word[idx]) {
				int next = idx + 1;

				if (next == word.length) {
					return true;
				}

				board[r][c] = '-';
				int rows = board.length;
				int cols = board[0].length;

				for (int i = 0; i < 4; i++) {
					int tr = r + DR[i], tc = c + DC[i];
					if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
						if (dfs(board, tr, tc, word, next)) {
							return true;
						}
					}
				}
				board[r][c] = word[idx];
			}
			return false;
		}

	}

}
