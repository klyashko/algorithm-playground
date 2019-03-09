package com.algorithm.playground.leetcode.problems.twopointers.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class IntersectionOfTwoArrays {

	class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int idx1 = 0;
			int idx2 = 0;
			int idx = 0;
			int prev = Integer.MAX_VALUE;
			int[] ans = new int[Math.min(nums1.length, nums2.length)];
			while (idx1 < nums1.length && idx2 < nums2.length) {
				if (nums1[idx1] < nums2[idx2]) {
					idx1++;
				} else if (nums1[idx1] > nums2[idx2]) {
					idx2++;
				} else {
					if (nums1[idx1] != prev) {
						ans[idx++] = nums1[idx1];
						prev = nums1[idx1];
					}
					idx1++;
					idx2++;
				}
			}
			return Arrays.copyOf(ans, idx);
		}
	}

}
