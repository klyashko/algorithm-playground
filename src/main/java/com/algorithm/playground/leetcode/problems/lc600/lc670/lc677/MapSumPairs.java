package com.algorithm.playground.leetcode.problems.lc600.lc670.lc677;

/**
 * https://leetcode.com/problems/map-sum-pairs/description/
 */
public class MapSumPairs {

	/**
	 * Your MapSum object will be instantiated and called as such:
	 * MapSum obj = new MapSum();
	 * obj.insert(key,val);
	 * int param_2 = obj.sum(prefix);
	 */
	class MapSum {

		private TrieNode root;

		/**
		 * Initialize your data structure here.
		 */
		public MapSum() {
			root = new TrieNode();
		}

		public void insert(String key, int val) {
			TrieNode curr = root;
			int prev = value(key);
			for (int i = 0; i < key.length(); i++) {
				int idx = key.charAt(i) - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
				curr.val += val - prev;
			}
			curr.isWord = true;
		}

		public int sum(String prefix) {
			TrieNode curr = node(prefix);
			return curr != null ? curr.val : 0;
		}

		private int value(String key) {
			TrieNode curr = node(key);
			return curr != null && curr.isWord ? curr.val : 0;
		}

		private TrieNode node(String key) {
			TrieNode curr = root;
			for (int i = 0; i < key.length(); i++) {
				int idx = key.charAt(i) - 'a';
				if (curr.children[idx] == null) {
					return null;
				}
				curr = curr.children[idx];
			}
			return curr;
		}

		private class TrieNode {
			int val;
			boolean isWord;
			TrieNode[] children = new TrieNode[26];
		}

	}

}
