package com.algorithm.playground.leetcode.problems.lc300.lc300.lc304;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

	private int[][] matrix;

	public NumMatrix(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			this.matrix = new int[0][0];
		} else {
			int cols = matrix[0].length;
			this.matrix = new int[rows + 1][cols + 1];
			int[][] tmp = new int[rows + 1][cols + 1];
			for (int r = 1; r <= rows; r++) {
				for (int c = 1; c <= cols; c++) {
					tmp[r][c] = tmp[r][c - 1] + matrix[r - 1][c - 1];
					this.matrix[r][c] = tmp[r][c] + this.matrix[r - 1][c];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int a = matrix[row2 + 1][col2 + 1] - matrix[row1][col2 + 1];
		int b = matrix[row2 + 1][col1] - matrix[row1][col1];
		return a - b;
	}

}
