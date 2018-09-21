package com.leetcode.problems.design.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/all-oone-data-structure/description/
 */
public class AllOOneDataStructure {

	class AllOne {

		private Map<String, Integer> counts = new HashMap<>();
		private TreeMap<Integer, Set<String>> strings = new TreeMap<>();
		private int min, max;

		/**
		 * Initialize your data structure here.
		 */
		public AllOne() { }

		/**
		 * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
		 */
		public void inc(String key) {
			int curr = getCountForUpdate(key);
			/** Update min */
			if (curr == min && strings.getOrDefault(curr, Collections.emptySet()).isEmpty()) {
				min++;
			}
			curr++;
			updateCount(key, curr);
			/** Update max */
			min = Math.min(min, curr);
			max = Math.max(max, curr);
		}

		/**
		 * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
		 */
		public void dec(String key) {
			int curr = getCountForUpdate(key);
			if (curr == 0) {
				return;
			}
			if (curr == max && strings.getOrDefault(curr, Collections.emptySet()).isEmpty()) {
				max--;
			}
			curr--;
			updateCount(key, curr);
			min = Math.min(min, curr);
			if (min == 0 && !strings.isEmpty()) {
				min = strings.firstKey();
			}
		}

		/**
		 * Returns one of the keys with maximal value.
		 */
		public String getMaxKey() {
			return getAnyForKey(max);
		}

		/**
		 * Returns one of the keys with Minimal value.
		 */
		public String getMinKey() {
			return getAnyForKey(min);
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
			if (count == 0) {
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
