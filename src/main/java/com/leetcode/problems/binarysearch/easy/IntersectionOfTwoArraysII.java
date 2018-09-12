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
			int idx1 = 0;
			int idx2 = 0;
			if (nums1.length < nums2.length) {
				int[] t = nums1;
				nums1 = nums2;
				nums2 = t;
			}
			boolean[] present = new boolean[nums2.length];
			int size = 0;
			while (idx1 < nums1.length && idx2 < nums2.length) {
				if (nums1[idx1] < nums2[idx2]) {
					idx1++;
				} else if (nums1[idx1] > nums2[idx2]) {
					idx2++;
				} else {
					size++;
					present[idx2] = true;
					idx1++;
					idx2++;
				}
			}
			int[] ans = new int[size];
			int idx = 0;
			for (int i = 0; i < nums2.length; i++) {
				if (!present[i]) {
					continue;
				}
				ans[idx++] = nums2[i];
			}
			return ans;
		}
	}

}
