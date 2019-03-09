package com.algorithm.playground.leetcode.problems.divideandconquer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {

	class Solution {
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> counts = new HashMap<>();
			for (int i : nums) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
			}
			int limit = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
			for (Integer key : counts.keySet()) {
				if (counts.get(key) >= limit) {
					return key;
				}
			}
			return 0;
		}
	}

}
