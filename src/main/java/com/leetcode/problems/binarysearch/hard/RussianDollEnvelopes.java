package com.leetcode.problems.binarysearch.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 */
public class RussianDollEnvelopes {

	class Solution {

		public int maxEnvelopes(int[][] envelopes) {
			int max = 0;
			Map<int[], Integer> cache = new HashMap<>();
			for (int[] en : envelopes) {
				max = Math.max(max, dfs(envelopes, en, cache));
			}
			return max;
		}

		private int dfs(int[][] envelopes, int[] envelope, Map<int[], Integer> cache) {
			if (!cache.containsKey(envelope)) {
				int max = 1;
				for (int[] en : envelopes) {
					if (en[0] < envelope[0] && en[1] < envelope[1]) {
						max = Math.max(max, dfs(envelopes, en, cache) + 1);
					}
				}
				cache.put(envelope, max);
			}
			return cache.get(envelope);
		}
	}

}
