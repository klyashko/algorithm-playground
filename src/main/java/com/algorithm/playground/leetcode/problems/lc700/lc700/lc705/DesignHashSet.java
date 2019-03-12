package com.algorithm.playground.leetcode.problems.lc700.lc700.lc705;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * https://leetcode.com/problems/design-hashset/description/
 */
public class DesignHashSet {

	class MyHashSet {

		@SuppressWarnings("unchecked")
		private ArrayList<Integer>[] buckets = new ArrayList[10000];

		/**
		 * Initialize your data structure here.
		 */
		public MyHashSet() { }

		public void add(int key) {
			int idx = key % buckets.length;
			ArrayList<Integer> bucket = buckets[idx];
			if (bucket == null) {
				buckets[idx] = new ArrayList<>();
				buckets[idx].add(key);
			} else {
				int i = 0;
				for (; i < bucket.size(); i++) {
					if (bucket.get(i) == key) {
						return;
					} else if (bucket.get(i) < key) {
						bucket.add(i, key);
						return;
					}
				}
				bucket.add(key);
			}

		}

		public void remove(int key) {
			int idx = key % buckets.length;
			ArrayList<Integer> bucket = buckets[idx];
			if (bucket != null) {
				Iterator<Integer> iterator = bucket.iterator();
				while (iterator.hasNext()) {
					int i = iterator.next();
					if (i == key) {
						iterator.remove();
						return;
					} else if (i < key) {
						return;
					}
				}
			}
		}

		/**
		 * Returns true if this set contains the specified element
		 */
		public boolean contains(int key) {
			int idx = key % buckets.length;
			ArrayList<Integer> bucket = buckets[idx];
			return bucket != null && bucket.contains(key);
		}
	}
}
