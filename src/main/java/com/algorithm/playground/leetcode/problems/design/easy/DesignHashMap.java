package com.algorithm.playground.leetcode.problems.design.easy;

/**
 * https://leetcode.com/problems/design-hashmap/description/
 */
public class DesignHashMap {


	class MyHashMap {

		private Node[] buckets = new Node[10000];

		/**
		 * Initialize your data structure here.
		 */
		public MyHashMap() { }

		/**
		 * value will always be non-negative.
		 */
		public void put(int key, int value) {
			int idx = key % buckets.length;
			Node bucket = buckets[idx];
			if (bucket == null) {
				buckets[idx] = new Node(key, value);
			} else {
				if (bucket.key == key) {
					bucket.val = value;
				} else {
					while (bucket.next != null && bucket.next.key >= key) {
						bucket = bucket.next;
					}
					if (bucket.key == key) {
						bucket.val = value;
					} else {
						Node n = new Node(key, value);
						n.next = bucket.next;
						bucket.next = n;
					}
				}
			}
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
		 */
		public int get(int key) {
			int idx = key % buckets.length;
			Node bucket = buckets[idx];
			if (bucket == null) {
				return -1;
			} else {
				if (bucket.key == key) {
					return bucket.val;
				}
				while (bucket.next != null && bucket.next.key >= key) {
					bucket = bucket.next;
				}
				return bucket.key == key ? bucket.val : -1;
			}
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping for the key
		 */
		public void remove(int key) {
			int idx = key % buckets.length;
			Node bucket = buckets[idx];
			if (bucket != null) {
				if (bucket.key == key) {
					buckets[idx] = bucket.next;
				} else {
					while (bucket.next != null && bucket.next.key > key) {
						bucket = bucket.next;
					}
					if (bucket.next != null && bucket.next.key == key) {
						bucket.next = bucket.next.next;
					}
				}
			}
		}

		private class Node {
			int key, val;
			Node next;

			public Node(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}
	}

}
