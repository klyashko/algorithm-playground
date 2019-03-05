package com.leetcode.problems.lc600.lc692;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
@SuppressWarnings("Duplicates")
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

	class PriorityQueueSolution {
		public List<String> topKFrequent(String[] words, int k) {
			Map<String, Integer> counts = new HashMap<>();
			for (String w : words) {
				counts.put(w, counts.getOrDefault(w, 0) + 1);
			}
			Queue<String> queue = new PriorityQueue<>((s1, s2) -> {
				if (counts.get(s1).equals(counts.get(s2))) {
					return s2.compareTo(s1);
				}
				return counts.get(s1) - counts.get(s2);
			});

			for (String key : counts.keySet()) {
				queue.offer(key);
				if (queue.size() > k) {
					queue.poll();
				}
			}

			List<String> result = new ArrayList<>();
			while (!queue.isEmpty()) {
				result.add(0, queue.poll());
			}
			return result;
		}
	}

}
