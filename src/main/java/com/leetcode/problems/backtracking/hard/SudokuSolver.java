package com.leetcode.problems.backtracking.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sudoku-solver/description/
 */
public class SudokuSolver {

	public static void main(String[] args) {
//		System.out.println(5 / 3 * 3);
		System.out.println((char) (1 + '0'));
		System.out.println((char) (3 + '0'));
		System.out.println((char) (5 + '0'));
	}

	class Solution {
		public void solveSudoku(char[][] board) {
			backtracking(board, 0, 0);
		}

		private boolean backtracking(char[][] board, int r, int c) {
			boolean[] options = new boolean[10];
			Arrays.fill(options, true);
			boolean found = false;
			for (int i = r; i < board.length && !found; i++) {
				for (int j = i == r ? c : 0; j < board.length; j++) {
					char ch = board[i][j];
					if (ch == '.') {
						found = true;
						r = i;
						c = j;
						break;
					}
				}
			}
			if (!found) {
				return true;
			} else if (!options(options, board, r, c)) {
				return false;
			}
			for (int i = 1; i < options.length; i++) {
				if (options[i]) {
					char ch = (char) (i + '0');
					board[r][c] = ch;
					if (backtracking(board, r, c + 1)) {
						return true;
					}
					board[r][c] = '.';
				}
			}
			return false;
		}

		private boolean options(boolean[] options, char[][] board, int r, int c) {
			for (int i = 0; i < board.length; i++) {
				char ch = board[r][i];
				if (ch != '.') {
					options[ch - '0'] = false;
				}

				ch = board[i][c];
				if (ch != '.') {
					options[ch - '0'] = false;
				}
			}
			int row = r / 3 * 3;
			int col = c / 3 * 3;
			for (int i = row; i < row + 3; i++) {
				for (int j = col; j < col + 3; j++) {
					char ch = board[i][j];
					if (ch != '.') {
						options[ch - '0'] = false;
					}
				}
			}
			int count = 0;
			for (int i = 1; i < options.length; i++) {
				if (options[i]) {
					count++;
				}
			}
			return count > 0;
		}
	}

}
