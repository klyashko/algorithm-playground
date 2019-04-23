package com.algorithm.playground.leetcode.problems.lc600.lc668;

/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 * <p>
 * Nearly every one have used the Multiplication Table.
 * But could you find out the k-th smallest number quickly from the multiplication table?
 * <p>
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k,
 * you need to return the k-th smallest number in this table.
 */
@SuppressWarnings("Duplicates")
public class KthSmallestNumberInMultiplicationTable {

	class Solution {
		public int findKthNumber(int m, int n, int k) {
			int li = 1, ri = m * n - 1;
			while (li <= ri) {
				int mid = (ri - li >> 1) + li;
				int count = 0;
				for (int i = m; i > 0; i--) {
					if (i * n <= mid) {
						count += n * i;
						break;
					} else if (n > 1) {
						count += Math.min(mid / i, n);
					}
				}
				if (count < k) {
					li = mid + 1;
				} else {
					ri = mid - 1;
				}
			}
			return li;
		}
	}

}
