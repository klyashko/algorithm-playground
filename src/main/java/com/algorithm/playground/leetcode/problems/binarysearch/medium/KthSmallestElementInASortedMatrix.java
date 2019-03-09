package com.algorithm.playground.leetcode.problems.binarysearch.medium;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 */
public class KthSmallestElementInASortedMatrix {

	class Solution {
		public int kthSmallest(int[][] matrix, int k) {
			int n = matrix.length;
			int[] indexes = new int[n];

			int row = 0;
			for (int i = 0; i < k; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if (indexes[j] == n) {
						continue;
					}
					if (min > matrix[j][indexes[j]]) {
						min = matrix[j][indexes[j]];
						row = j;
					}
				}
				indexes[row]++;
			}

			return matrix[row][indexes[row] - 1];
		}
	}

	class BinarySearchSolution {

		public int kthSmallest(int[][] matrix, int k) {
			int n = matrix.length;
			int l = matrix[0][0];
			int r = matrix[n - 1][n - 1] + 1;
			while (l < r) {
				int mid = l + (r - l) / 2;
				int lessOrEquals = 0;
				int idx = n - 1;
				for (int[] row : matrix) {
					while (idx >= 0 && row[idx] > mid) {
						idx--;
					}
					lessOrEquals += idx + 1;
				}
				if (lessOrEquals < k) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			return l;
		}

	}

}
