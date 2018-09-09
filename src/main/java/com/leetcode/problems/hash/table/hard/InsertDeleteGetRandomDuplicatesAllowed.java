package com.leetcode.problems.hash.table.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

	class RandomizedCollection {

		private List<Integer> values = new ArrayList<>();
		private Random rnd = new Random();
		private Map<Integer, Set<Integer>> positions = new HashMap<>();

		/**
		 * Initialize your data structure here.
		 */
		public RandomizedCollection() {

		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean contains = positions.containsKey(val);
			values.add(val);
			int idx = values.size() - 1;
			if (!contains) {
				positions.put(val, new HashSet<>());
			}
			positions.get(val).add(idx);
			return !contains;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained the specified element.
		 */
		public boolean remove(int val) {
			Set<Integer> list = positions.get(val);
			if (list == null) {
				return false;
			}
			int idx = list.iterator().next();
			list.remove(idx);
			int lastIdx = values.size() - 1;
			if (idx < lastIdx) {
				int lastVal = values.get(lastIdx);
				Set<Integer> set = positions.get(lastVal);
				set.remove(lastIdx);
				set.add(idx);
				values.set(idx, lastVal);
				values.remove(lastIdx);
			} else {
				values.remove(lastIdx);
			}
			if (list.isEmpty()) {
				positions.remove(val);
			}
			return true;
		}

		/**
		 * Get a random element from the collection.
		 */
		public int getRandom() {
			if (values.isEmpty()) {
				return 0;
			}
			int idx = rnd.nextInt(values.size());
			return values.get(idx);
		}
	}

}
