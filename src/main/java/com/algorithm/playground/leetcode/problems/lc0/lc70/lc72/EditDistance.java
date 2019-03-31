package com.algorithm.playground.leetcode.problems.lc0.lc70.lc72;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

	class Solution {
		public int minDistance(String word1, String word2) {
			int rows = word1.length();
			int cols = word2.length();
			int[][] distances = new int[rows + 1][cols + 1];

			for (int r = 1; r <= rows; r++) {
				distances[r][0] = r;
			}

			for (int c = 1; c <= cols; c++) {
				distances[0][c] = c;
			}

			for (int r = 1; r <= rows; r++) {
				for (int c = 1; c <= cols; c++) {
					if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
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

			return distances[rows][cols];
		}
	}

}
