package com.leetcode.problems.lc867;

/**
 * https://leetcode.com/problems/transpose-matrix/description/
 */
public class TransposeMatrix {

	public class Solution {
		public int[][] transpose(int[][] A) {
			int[][] a = new int[A[0].length][A.length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < A.length; j++) {
					a[i][j] = A[j][i];
				}
			}
			return a;

		}
	}

}
