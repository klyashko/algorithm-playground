package com.leetcode.problems.binarysearch.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 */
public class RussianDollEnvelopes {

	class Solution {

		public int maxEnvelopes(int[][] envelopes) {
			List<int[]> list = Arrays.asList(envelopes);
			list.sort((e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);

			Map<int[], Integer> cache = new HashMap<>();
			int max = 0;
			for (int i = list.size() - 1; i >= 0 && i - max >= 0; i--) {
				max = Math.max(max, dfs(list, list.get(i), cache));
			}
			return max;
		}

		private int dfs(List<int[]> envelopes, int[] envelope, Map<int[], Integer> cache) {
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

}
