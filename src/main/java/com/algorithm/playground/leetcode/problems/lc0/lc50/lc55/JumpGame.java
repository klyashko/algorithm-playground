package com.algorithm.playground.leetcode.problems.lc0.lc50.lc55;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

	class Solution {
		public boolean canJump(int[] nums) {
			int curr = 0;
			for (int i = 0; i < nums.length; i++) {
				if (curr < i) {
					return false;
				}
				curr = Math.max(curr, i + nums[i]);
			}
			return true;
		}
	}

}
