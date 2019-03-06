package com.leetcode.problems.lc500.lc560;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {

	class Solution {
		public int subarraySum(int[] nums, int k) {
			Map<Integer, Integer> sums = new HashMap<>();
			int count = 0, sum = 0;

			sums.put(0, 1);
			for (int i : nums) {
				sum += i;
				count += sums.getOrDefault(sum - k, 0);
				sums.put(sum, sums.getOrDefault(sum, 0) + 1);
			}

			return count;
		}
	}

	class CamSumSolution {
		public int subarraySum(int[] nums, int k) {
			int[] col = new int[nums.length];

			int count = 0;
			for (int c = 0; c < nums.length; c++) {
				for (int r = 0; r <= c; r++) {
					col[r] = col[r] + nums[c];
					if (col[r] == k) {
						count++;
					}
				}
			}

			return count;
		}
	}

}
