package com.algorithm.playground.leetcode.problems.lc0.lc40.lc48;

/**
 * https://leetcode.com/problems/rotate-image/
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

	class Solution {

		public void rotate(int[][] matrix) {
			int n = matrix.length - 1;
			int[][] tmp = new int[n + 1][n + 1];
			for (int r = 0; r <= n; r++) {
				for (int c = 0; c <= n; c++) {
					tmp[c][n - r] = matrix[r][c];
				}
			}
			for (int i = 0; i <= n; i++) {
				System.arraycopy(tmp[i], 0, matrix[i], 0, n + 1);
			}
		}

	}

}
