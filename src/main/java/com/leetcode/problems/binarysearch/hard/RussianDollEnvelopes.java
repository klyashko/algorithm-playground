package com.leetcode.problems.binarysearch.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 */
public class RussianDollEnvelopes {

	class Solution {

		public int maxEnvelopes(int[][] envelopes) {
			Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
			Map<int[], Integer> cache = new HashMap<>();
			int max = 0;
			for (int i = envelopes.length - 1; i >= 0 && i - max >= 0; i--) {
				max = Math.max(max, dfs(envelopes, envelopes[i], cache));
			}
			return max;
		}

		private int dfs(int[][] envelopes, int[] envelope, Map<int[], Integer> cache) {
			if (!cache.containsKey(envelope)) {
				int max = 1;
				for (int[] en : envelopes) {
					if (en[0] < envelope[0] && en[1] < envelope[1]) {
						max = Math.max(max, dfs(envelopes, en, cache) + 1);
					} else if (en[0] >= envelope[0]) {
						break;
					}
				}
				cache.put(envelope, max);
			}
			return cache.get(envelope);
		}
	}

	class DPSolution {

		public int maxEnvelopes(int[][] nums) {
			//Arrays.sort(nums, (a,b) -> a[0]-b[0]);
			//there was a problem here because a[0] can be equal to b[0]
			//but a[1] would larger than b[1] which makes it a ascending sequence and we don't want it
			//if a[0]==b[0], we need to switching a[1] b[1] by descending.
			Arrays.sort(nums, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
			int m = nums.length;
			int[] dp = new int[m];
			int len = 0;
			for (int[] num : nums) {
				int insert = Arrays.binarySearch(dp, 0, len, num[1]);
				if (insert < 0) {
					insert = -(insert + 1);
				}
				if (insert == len) {
					len++;
				}
				dp[insert] = num[1];
			}
			return len;
		}
	}

}
