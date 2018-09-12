package com.leetcode.problems.binarysearch.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/4sum-ii/description/
 */
public class Sum4II {

	class Solution {
		public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
			int count = 0;
			int N = A.length;
			int[] AB = new int[N * N];
			int[] CD = new int[N * N];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					AB[idx] = A[i] + B[j];
					CD[idx] = C[i] + D[j];
					idx++;
				}
			}
			Arrays.sort(AB);
			Arrays.sort(CD);

			for (int aAB : AB) {
				int j = binarySearch(CD, aAB);
				if (j != -1) {
					count++;
					for (int g = j + 1; g < CD.length && CD[g] == CD[j]; g++) {
						count++;
					}
					for (int g = j - 1; g >= 0 && CD[g] == CD[j]; g--) {
						count++;
					}
				}
			}

			return count;
		}

		private int binarySearch(int[] nums, int curr) {
			int l = 0, r = nums.length - 1;
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (curr + nums[mid] < 0) {
					l = mid + 1;
				} else if (curr + nums[mid] == 0) {
					return mid;
				} else {
					r = mid;
				}
			}
			return curr + nums[l] == 0 ? l : -1;
		}
	}

}
