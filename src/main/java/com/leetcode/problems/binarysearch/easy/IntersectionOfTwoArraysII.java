package com.leetcode.problems.binarysearch.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class IntersectionOfTwoArraysII {

	class Solution {
		public int[] intersect(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int[] ans = new int[Math.max(nums1.length, nums2.length)];
			int idx = 0, idx1 = 0, idx2 = 0;
			while (idx1 < nums1.length && idx2 < nums2.length) {
				if (nums1[idx1] < nums2[idx2]) {
					idx1++;
				} else if (nums1[idx1] > nums2[idx2]) {
					idx2++;
				} else {
					ans[idx++] = nums2[idx2++];
					idx1++;
				}
			}
			return Arrays.copyOf(ans, idx);
		}
	}

}
