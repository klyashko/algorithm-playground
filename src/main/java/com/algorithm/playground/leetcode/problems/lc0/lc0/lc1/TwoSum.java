package com.algorithm.playground.leetcode.problems.lc0.lc0.lc1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * <p>
 * Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class TwoSum {

	class Solution {

		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int diff = target - nums[i];
				Integer idx = map.get(diff);
				if (idx != null) {
					return new int[]{idx, i};
				}
				map.put(nums[i], i);
			}
			return null;
		}

	}

}
