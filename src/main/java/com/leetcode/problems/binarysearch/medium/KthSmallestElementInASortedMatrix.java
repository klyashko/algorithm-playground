package com.leetcode.problems.binarysearch.medium;

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

}
