package com.algorithm.playground.leetcode.problems.lc400.lc494;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/
 * <p>
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

	class Solution {

		public int findTargetSumWays(int[] nums, int S) {
			int sum = 0;
			for (int i : nums) {
				sum += i;
			}
			int[][] cache = new int[(sum + 1) << 1][nums.length];
			for (int[] row : cache) {
				Arrays.fill(row, -1);
			}
			return dp(nums, 0, S, 0, cache, sum);
		}

		private int dp(int[] nums, int curr, int S, int idx, int[][] cache, int size) {
			if (idx == nums.length) {
				return curr == S ? 1 : 0;
			}
			int cacheIdx = curr < 0 ? -curr : curr + size;
			if (cache[cacheIdx][idx] != -1) {
				return cache[cacheIdx][idx];
			} else {
				int val = nums[idx++];
				int n = dp(nums, curr + val, S, idx, cache, size) + dp(nums, curr - val, S, idx, cache, size);
				return cache[cacheIdx][idx - 1] = n;
			}
		}

	}

}
