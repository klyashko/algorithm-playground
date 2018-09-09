package com.leetcode.problems.hash.table.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

	class RandomizedCollection {

		private List<Integer> list = new ArrayList<>();
		private Random rnd = new Random();

		/**
		 * Initialize your data structure here.
		 */
		public RandomizedCollection() {

		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean contains = list.contains(val);
			list.add(val);
			return contains;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained the specified element.
		 */
		public boolean remove(int val) {
			return list.remove((Integer) val);
		}

		/**
		 * Get a random element from the collection.
		 */
		public int getRandom() {
			if (list.isEmpty()) {
				return 0;
			}
			int idx = rnd.nextInt(list.size());
			return list.get(idx);
		}
	}

}
