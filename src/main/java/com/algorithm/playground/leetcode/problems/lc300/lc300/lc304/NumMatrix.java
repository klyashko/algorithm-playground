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
			this.matrix = new int[rows][cols + 1];
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					this.matrix[r][c + 1] = this.matrix[r][c] + matrix[r][c];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += matrix[i][col2 + 1] - matrix[i][col1];
		}
		return sum;
	}

}
