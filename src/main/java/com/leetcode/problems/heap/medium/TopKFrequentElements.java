package com.leetcode.problems.heap.medium;

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

}
