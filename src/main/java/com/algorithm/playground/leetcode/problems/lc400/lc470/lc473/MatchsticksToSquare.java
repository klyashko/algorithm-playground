package com.algorithm.playground.leetcode.problems.lc400.lc470.lc473;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class MatchsticksToSquare {

	class Solution {
		public boolean makesquare(int[] nums) {
			boolean[] used = new boolean[nums.length];
			int sum = 0;
			for (int i : nums) {
				sum += i;
			}
			if (sum % 4 != 0 || sum == 0) {
				return false;
			}
			sum /= 4;

			Arrays.sort(nums);
			used[used.length - 1] = true;
			return dfs(nums, used, nums[nums.length - 1], sum, 4);
		}

		private boolean dfs(int[] nums, boolean[] used, int curr, int expected, int ittr) {
			if (curr > expected) {
				return false;
			} else {
				if (curr == expected) {
					curr = 0;
					ittr--;
					if (ittr == 0) {
						return true;
					}
				}
				for (int i = nums.length - 1; i >= 0; i--) {
					if (!used[i]) {
						used[i] = true;
						if (dfs(nums, used, curr + nums[i], expected, ittr)) {
							return true;
						}
						used[i] = false;
					}
				}
			}
			return false;
		}
	}

}
