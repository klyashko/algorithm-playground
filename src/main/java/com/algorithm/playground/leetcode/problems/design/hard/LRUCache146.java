package com.algorithm.playground.leetcode.problems.design.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCache146 {

	public static LRUCache lruCache(int capacity) {
		return new LRUCache146().createLRUCache(capacity);
	}

	private LRUCache createLRUCache(int capacity) {
		return new LRUCache(capacity);
	}

	class LRUCache {

		private Map<Integer, Entry> map = new HashMap<>();
		private TreeSet<Entry> set = new TreeSet<>(Comparator.comparingLong(e -> e.time));
		private long time;
		private int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			Entry entry = map.get(key);
			if (entry == null) {
				return -1;
			}
			set.remove(entry);
			entry.time = time++;
			set.add(entry);
			return entry.val;
		}

		public void put(int key, int value) {
			if (map.size() == capacity && !map.containsKey(key)) {
				Entry first = set.first();
				set.remove(first);
				map.remove(first.key);
			} else if (map.containsKey(key)) {
				set.remove(map.get(key));
			}
			Entry entry = new Entry(key, value, time++);
			map.put(entry.key, entry);
			set.add(entry);
		}

		private class Entry {
			Integer key, val;
			long time;

			public Entry(Integer key, Integer val, long time) {
				this.key = key;
				this.val = val;
				this.time = time;
			}
		}

	}

}
