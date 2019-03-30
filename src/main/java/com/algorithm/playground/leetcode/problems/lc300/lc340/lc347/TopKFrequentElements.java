package com.algorithm.playground.leetcode.problems.lc300.lc340.lc347;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {

	class Solution {
		public List<Integer> topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> counts = new HashMap<>();
			for (int i : nums) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
			}
			//noinspection SuspiciousMethodCalls
			Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(counts::get).reversed());
			queue.addAll(counts.keySet());

			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				result.add(queue.poll());
			}
			return result;
		}
	}

	class BucketSortSolution {
		public List<Integer> topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> counts = new HashMap<>();
			for (int i : nums) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
			}
			//noinspection unchecked
			ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
			for (int key : counts.keySet()) {
				Integer count = counts.get(key);
				if (buckets[count] == null) {
					buckets[count] = new ArrayList<>();
				}
				buckets[count].add(key);
			}
			List<Integer> result = new ArrayList<>();
			for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
				if (buckets[i] != null) {
					result.addAll(buckets[i]);
				}
			}
			return result;
		}
	}

}
