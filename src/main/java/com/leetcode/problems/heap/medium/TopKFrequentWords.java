package com.leetcode.problems.heap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class TopKFrequentWords {

	class Solution {
		public List<String> topKFrequent(String[] words, int k) {
			Map<String, Integer> counts = new HashMap<>();
			for (String w : words) {
				counts.put(w, counts.getOrDefault(w, 0) + 1);
			}
			//noinspection unchecked
			ArrayList<String>[] buckets = new ArrayList[words.length];
			for (String key : counts.keySet()) {
				Integer count = counts.get(key);
				if (buckets[count] == null) {
					buckets[count] = new ArrayList<>();
				}
				buckets[count].add(key);
			}
			List<String> result = new ArrayList<>();
			for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
				if (buckets[i] != null) {
					buckets[i].sort(String::compareTo);
					result.addAll(buckets[i]);
				}
			}
			return result.subList(0, k);
		}
	}

}
