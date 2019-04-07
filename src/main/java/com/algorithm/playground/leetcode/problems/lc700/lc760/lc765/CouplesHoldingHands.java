package com.algorithm.playground.leetcode.problems.lc700.lc760.lc765;

/**
 * https://leetcode.com/problems/couples-holding-hands/description/
 */
public class CouplesHoldingHands {

	class Solution {
		public int minSwapsCouples(int[] row) {
			int count = 0;
			for (int i = 0; i < row.length; i += 2) {
				int curr = row[i];
				int couple = curr % 2 == 0 ? curr + 1 : curr - 1;
				if (row[i + 1] != couple) {
					int idx = search(row, couple, i + 1);
					swap(row, i + 1, idx);
					count++;
				}
			}
			return count;
		}

		private int search(int[] row, int key, int from) {
			int idx = from;
			for (; idx < row.length; idx++) {
				if (row[idx] == key) {
					return idx;
				}
			}
			return -1;
		}

		private void swap(int[] row, int i, int j) {
			int t = row[i];
			row[i] = row[j];
			row[j] = t;
		}
	}

}
