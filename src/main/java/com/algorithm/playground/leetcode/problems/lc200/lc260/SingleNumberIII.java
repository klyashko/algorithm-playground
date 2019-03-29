package com.algorithm.playground.leetcode.problems.lc200.lc260;

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

	class FastSolution {
		public int[] singleNumber(int[] nums) {
			int xor = 0;
			for (int i : nums) {
				xor ^= i;
			}
			xor = xor & -xor;
			int[] ans = new int[2];
			for (int i : nums) {
				if ((i & xor) == 0) {
					ans[0] ^= i;
				} else {
					ans[1] ^= i;
				}
			}
			return ans;
		}
	}

}
