package com.algorithm.playground.leetcode.problems.trie.medium;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
@SuppressWarnings("Duplicates")
public class ImplementTrie {

	class Trie {

		private TrieNode root = new TrieNode();

		/**
		 * Initialize your data structure here.
		 */
		public Trie() { }

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			TrieNode curr = root;
			for (char ch : word.toCharArray()) {
				int idx = ch - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
			}
			curr.isWord = true;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			TrieNode curr = root;
			for (char ch : word.toCharArray()) {
				int idx = ch - 'a';
				if (curr.children[idx] == null) {
					return false;
				}
				curr = curr.children[idx];
			}
			return curr.isWord;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode curr = root;
			for (char ch : prefix.toCharArray()) {
				int idx = ch - 'a';
				if (curr.children[idx] == null) {
					return false;
				}
				curr = curr.children[idx];
			}
			return true;
		}

		private class TrieNode {
			TrieNode[] children = new TrieNode[26];
			boolean isWord;
		}
	}

}
