package com.algorithm.playground.leetcode.problems.lc0.lc70.lc72;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

	class Solution {
		public int minDistance(String word1, String word2) {
			int rows = word1.length();
			int cols = word2.length();
			if (rows == 0 || cols == 0) {
				return rows == 0 ? cols : rows;
			}
			int[][] distances = new int[rows][cols];

			distances[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

			for (int r = 1; r < rows; r++) {
				if (word1.charAt(r) == word2.charAt(0)) {
					distances[r][0] = distances[r - 1][0];
				} else {
					distances[r][0] = distances[r - 1][0] + 1;
				}
			}

			for (int c = 1; c < cols; c++) {
				if (word1.charAt(0) == word2.charAt(c)) {
					distances[0][c] = distances[0][c - 1];
				} else {
					distances[0][c] = distances[0][c - 1] + 1;
				}
			}

			for (int r = 1; r < rows; r++) {
				for (int c = 1; c < cols; c++) {
					if (word1.charAt(r) == word2.charAt(c)) {
						distances[r][c] = distances[r - 1][c - 1];
					} else {
						//update
						int min = distances[r - 1][c - 1];
						//remove
						min = Math.min(min, distances[r - 1][c]);
						//insert
						min = Math.min(min, distances[r][c - 1]);
						distances[r][c] = min + 1;
					}
				}
			}
			return distances[rows - 1][cols - 1];
		}
	}

}
