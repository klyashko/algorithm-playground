package com.algorithm.playground.leetcode.problems.lc200.lc230.lc239;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {

	class Solution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			if (nums.length == 0) {
				return new int[0];
			}
			int[] res = new int[nums.length - k + 1];
			//It's better to use dequeue here
			int[] window = new int[k + 1];
			int idx = 0;
			for (int i = 0; i < k; i++) {
				idx = insert(window, idx, nums[i]);
			}

			res[0] = window[1];
			for (int l = 1; l < res.length; l++) {
				int r = l + k - 1;
				if (window[1] == nums[l - 1]) {
					System.arraycopy(window, 2, window, 1, window.length - 2);
					idx--;
				}

				idx = insert(window, idx, nums[r]);

				res[l] = window[1];
			}
			return res;
		}

		private int insert(int[] window, int idx, int val) {
			while (idx != 0 && window[idx] < val) {
				idx--;
			}
			window[++idx] = val;
			return idx;
		}

	}

}
