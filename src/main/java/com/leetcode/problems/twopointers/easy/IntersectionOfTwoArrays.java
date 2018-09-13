package com.leetcode.problems.twopointers.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 */
public class IntersectionOfTwoArrays {

	class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			Set<Integer> result = new HashSet<>();
			int idx1 = 0, idx2 = 0;
			while (idx1 < nums1.length && idx2 < nums2.length) {
				if (nums1[idx1] < nums2[idx2]) {
					idx1++;
				} else if (nums1[idx1] > nums2[idx2]) {
					idx2++;
				} else {
					result.add(nums1[idx1]);
					idx1++;
					idx2++;
				}
			}
			int[] ans = new int[result.size()];
			int idx = 0;
			for (int i : result) {
				ans[idx++] = i;
			}
			return ans;
		}
	}

}
