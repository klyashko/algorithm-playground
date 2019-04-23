package com.algorithm.playground.leetcode.problems.lc900.lc920.lc927;

/**
 * https://leetcode.com/problems/three-equal-parts/
 * <p>
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such that all of these parts represent the same binary value.
 * <p>
 * If it is possible, return any [i, j] with i+1 < j, such that:
 * <p>
 * A[0], A[1], ..., A[i] is the first part;
 * A[i+1], A[i+2], ..., A[j-1] is the second part, and
 * A[j], A[j+1], ..., A[A.length - 1] is the third part.
 * All three parts have equal binary value.
 * If it is not possible, return [-1, -1].
 * <p>
 * Note that the entire part is used when considering what binary value it represents.
 * For example, [1,1,0] represents 6 in decimal, not 3.
 * Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 */
public class ThreeEqualParts {

	class Solution {
		public int[] threeEqualParts(int[] A) {
			int count = 0;
			int[] index = new int[A.length];
			int curr = -1;
			int last = -1;
			for (int i = A.length - 1; i >= 0; i--) {
				if (A[i] == 1) {
					count++;
					curr = i;
					if (last == -1) {
						last = i;
					}
				}
				index[i] = curr;
			}
			if (count % 3 != 0) {
				return new int[]{-1, -1};
			} else if (last == -1) {
				return new int[]{0, A.length - 1};
			}
			int n = count / 3;
			int start = index[0];
			int end = start;
			for (int i = 1; i < n; i++) {
				end = index[end + 1];
			}

			end += A.length - last - 1;
			int len = end - start + 1;

			if (equals(A, start, start + len, index[end + 1], index[end + 1] + len)) {
				if (equals(A, start, start + len, index[index[end + 1] + len], A.length)) {
					return new int[]{end, index[end + 1] + len};
				}
			}

			return new int[]{-1, -1};
		}

		private boolean equals(int[] data, int from1, int to1, int from2, int to2) {
			if (to1 - from1 != to2 - from2) {
				return false;
			}
			int len = to1 - from1;
			for (int i = 0; i < len; i++) {
				if (data[from1 + i] != data[from2 + i]) {
					return false;
				}
			}
			return true;
		}

	}

}
