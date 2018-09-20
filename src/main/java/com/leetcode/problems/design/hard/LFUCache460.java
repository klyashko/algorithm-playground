package com.leetcode.problems.design.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/lfu-cache/description/
 */
public class LFUCache460 {

	public static LFUCache lfuCache(int capacity) {
		return new LFUCache460().createLFUCache(capacity);
	}

	private LFUCache createLFUCache(int capacity) {
		return new LFUCache(capacity);
	}

	class LFUCache {

		private Map<Integer, Node> cache = new HashMap<>();
		private TreeSet<Node> nodes = new TreeSet<>(
				(n1, n2) -> n1.freq == n2.freq ? Long.compare(n1.time, n2.time) : Integer.compare(n1.freq, n2.freq)
		);
		private int capacity;
		private long time;

		public LFUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			Node node = cache.get(key);
			if (node != null) {
				nodes.remove(node);
				node.freq++;
				node.time = time++;
				nodes.add(node);
				return node.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (capacity == 0) {
				return;
			}
			if (cache.size() == capacity && !cache.containsKey(key)) {
				Node first = nodes.first();
				nodes.remove(first);
				cache.remove(first.key);
			} else if (cache.containsKey(key)) {
				Node node = cache.get(key);
				nodes.remove(node);
				node.freq++;
				node.val = value;
				node.time = time++;
				nodes.add(node);
				return;
			}
			Node node = new Node(key, value);
			node.time = time++;
			cache.put(key, node);
			nodes.add(node);
		}

		private class Node {
			int key, val, freq;
			long time;

			public Node(int key, int val) {
				this.key = key;
				this.val = val;
			}

			@Override
			public String toString() {
				return "Node{" +
						"key=" + key +
						", val=" + val +
						'}';
			}
		}
	}

}
