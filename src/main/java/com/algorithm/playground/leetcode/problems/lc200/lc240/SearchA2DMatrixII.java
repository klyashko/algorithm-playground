package com.algorithm.playground.leetcode.problems.lc200.lc240;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class SearchA2DMatrixII {

	class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			for (int[] row : matrix) {
				if (binarySearch(row, target)) {
					return true;
				}
			}
			return false;
		}

		private boolean binarySearch(int[] array, int target) {
			int li = 0, ri = array.length;
			while (li < ri) {
				int mid = li + (ri - li) / 2;
				if (array[mid] < target) {
					li = mid + 1;
				} else {
					ri = mid;
				}
			}
			return li < array.length && array[li] == target;
		}
	}

}
