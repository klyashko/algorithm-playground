package com.leetcode.problems.heap.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementInAnArray {

	class Solution {
		public int findKthLargest(int[] nums, int k) {
			Arrays.sort(nums);
			return nums[nums.length - k];
		}
	}

}
