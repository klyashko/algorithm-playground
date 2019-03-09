package com.algorithm.playground.leetcode.problems.binarysearch.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
			Map<Integer, Integer> counts = new HashMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++, idx++) {
					AB[idx] = A[i] + B[j];
					CD[idx] = C[i] + D[j];
					counts.put(CD[idx], counts.getOrDefault(CD[idx], 0) + 1);
				}
			}
			Arrays.sort(AB);
			Arrays.sort(CD);

			int prevVal = Integer.MIN_VALUE;
			int prevScore = 0;

			for (int a : AB) {
				if (a != prevVal) {
					prevVal = a;
					int j = binarySearch(CD, a);
					if (j != -1) {
						prevScore = counts.get(CD[j]);
					} else {
						prevScore = 0;
					}
				}
				count += prevScore;
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

	class FastSolution {
		public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int a : A) {
				for (int b : B) {
					int sum = a + b;
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
			int res = 0;
			for (int c : C) {
				for (int d : D) {
					res += map.getOrDefault(0 - c - d, 0);
				}
			}
			return res;
		}
	}

}
