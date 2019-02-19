package com.leetcode.problems.lc832;

/**
 * https://leetcode.com/problems/flipping-an-image/description/
 */
public class Solution {

	public int[][] flipAndInvertImage(int[][] A) {
		for (int[] row : A) {
			for (int i = 0; i < row.length / 2; i++) {
				int tmp = row[i];
				int idx = row.length - i - 1;
				row[i] = (row[idx] + 1) % 2;
				row[idx] = (tmp + 1) % 2;
			}
			if (row.length % 2 == 1) {
				int idx = row.length / 2;
				row[idx] = (row[idx] + 1) % 2;
			}
		}
		return A;
	}

}
