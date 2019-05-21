package com.algorithm.playground.leetcode.problems.lc300.lc330.lc330;

/**
 * https://leetcode.com/problems/patching-array/
 */
public class PatchingArray {

	class Solution {

		public int minPatches(int[] nums, int n) {
			long next = 1;
			int count = 0, idx = 0;
			while (next <= n) {
				if (idx < nums.length && nums[idx] <= next) {
					next += nums[idx++];
				} else {
					next <<= 1;
					count++;
				}
			}
			return count;
		}

	}

}
