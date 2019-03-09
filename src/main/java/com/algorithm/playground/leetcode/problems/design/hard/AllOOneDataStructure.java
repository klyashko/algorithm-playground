package com.algorithm.playground.leetcode.problems.design.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/all-oone-data-structure/description/
 */
public class AllOOneDataStructure {

	class AllOne {

		private Map<String, Integer> counts = new HashMap<>();
		private TreeMap<Integer, Set<String>> strings = new TreeMap<>();

		/**
		 * Initialize your data structure here.
		 */
		public AllOne() { }

		/**
		 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
		 */
		public void inc(String key) {
			updateCount(key, getCountForUpdate(key) + 1);
		}

		/**
		 * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
		 */
		public void dec(String key) {
			updateCount(key, getCountForUpdate(key) - 1);
		}

		/**
		 * Returns one of the keys with maximal value.
		 */
		public String getMaxKey() {
			return getAnyForKey(strings.isEmpty() ? 0 : strings.lastKey());
		}

		/**
		 * Returns one of the keys with Minimal value.
		 */
		public String getMinKey() {
			return getAnyForKey(strings.isEmpty() ? 0 : strings.firstKey());
		}

		private int getCountForUpdate(String key) {
			int curr = counts.getOrDefault(key, 0);
			if (strings.containsKey(curr)) {
				Set<String> set = strings.get(curr);
				set.remove(key);
				if (set.isEmpty()) {
					strings.remove(curr);
				}
			}
			return curr;
		}

		private void updateCount(String key, int count) {
			if (count <= 0) {
				counts.remove(key);
			} else {
				counts.put(key, count);
				if (!strings.containsKey(count)) {
					strings.put(count, new HashSet<>());
				}
				strings.get(count).add(key);
			}
		}

		private String getAnyForKey(int key) {
			if (key == 0) {
				return "";
			}
			return strings.get(key).iterator().next();
		}
	}

}
