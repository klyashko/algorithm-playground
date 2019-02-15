package com.leetcode.problems.array.easy;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

	class Solution {
		public void rotate(int[] nums, int k) {
			if (k == 0) {
				return;
			}
			int gcd = gcd(k, nums.length);
			if (gcd == 1) {
				int idx = k % nums.length, tmp = nums[0];
				for (int i = 0; i < nums.length; i++) {
					tmp = swap(nums, idx, tmp);
					idx = (idx + k) % nums.length;
				}
			} else {
				for (int j = 0; j < gcd; j++) {
					int idx = (k + j) % nums.length, tmp = nums[j];
					for (int i = 0; i < nums.length / gcd; i++) {
						tmp = swap(nums, idx, tmp);
						idx = (idx + k) % nums.length;
					}
				}
			}
		}

		private int swap(int[] nums, int idx, int value) {
			int tmp = nums[idx];
			nums[idx] = value;
			return tmp;
		}

		private int gcd(int p, int q) {
			if (q == 0) {
				return p;
			}
			return gcd(q, p % q);
		}
	}

}
