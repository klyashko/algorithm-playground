package com.algorithm.playground.leetcode.problems.lc800.lc860.lc861;

import java.util.Arrays;

public class ScoreAfterFlippingMatrix {

	class Solution {
		public int matrixScore(int[][] A) {
			Arrays.sort(A, (a1, a2) -> {
				for (int i = 0; i < a1.length; i++) {
					int diff = a1[i] - a2[i];
					if (diff != 0) {
						return diff;
					}
				}
				return 0;
			});

			for (int[] row : A) {
				int before = toInt(row);
				flip(row);
				int after = toInt(row);
				if (after < before) {
					flip(row);
					break;
				}
			}

			int sum = sum(A);

			for (int i = 0; i < A[0].length; i++) {
				flip(A, i);
				int tmp = sum(A);
				if (tmp < sum) {
					flip(A, i);
				} else {
					sum = tmp;
				}
			}

			return sum;
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
				arr[i] = (arr[i] + 1) % 2;
			}
		}

		private void flip(int[][] arr, int c) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][c] = (arr[i][c] + 1) % 2;
			}
		}

		private int toInt(int[] arr) {
			StringBuilder builder = new StringBuilder();
			for (int i : arr) {
				builder.append(i);
			}
			return Integer.parseInt(builder.toString(), 2);
		}
	}

}
