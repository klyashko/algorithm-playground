package com.leetcode.problems.bitmanipulation.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number-iii/description/
 */
public class SingleNumberIII {

	class Solution {
		public int[] singleNumber(int[] nums) {
			Set<Integer> set = new HashSet<>();
			for (int i : nums) {
				if (!set.add(i)) {
					set.remove(i);
				}
			}
			int[] ans = new int[set.size()];
			int idx = 0;
			for (int i : set) {
				ans[idx++] = i;
			}
			return ans;
		}
	}

}
