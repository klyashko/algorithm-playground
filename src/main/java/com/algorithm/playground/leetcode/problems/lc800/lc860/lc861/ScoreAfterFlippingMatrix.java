package com.algorithm.playground.leetcode.problems.lc800.lc860.lc861;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 */
public class ScoreAfterFlippingMatrix {

	class Solution {
		public int matrixScore(int[][] A) {
			for (int[] row : A) {
				int before = toInt(row);
				flip(row);
				int after = toInt(row);
				if (after < before) {
					flip(row);
				}
			}

			int half = (A.length >> 1) + (A.length & 1);

			for (int i = 0; i < A[0].length; i++) {
				int count = count(A, i);
				if (count < half) {
					flip(A, i);
				}
			}

			return sum(A);
		}

		private int sum(int[][] A) {
			int sum = 0;
			for (int[] i : A) {
				sum += toInt(i);
			}
			return sum;
		}

		private void flip(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (arr[i] + 1) & 1;
			}
		}

		private void flip(int[][] arr, int c) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][c] = (arr[i][c] + 1) & 1;
			}
		}

		private int count(int[][] arr, int c) {
			int count = 0;
			for (int[] row : arr) {
				count += row[c];
			}
			return count;
		}

		private int toInt(int[] arr) {
			int val = 0;
			for (int i : arr) {
				val = (val << 1) + i;
			}
			return val;
		}
	}

}
