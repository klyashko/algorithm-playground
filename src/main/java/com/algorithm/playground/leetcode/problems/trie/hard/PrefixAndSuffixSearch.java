package com.algorithm.playground.leetcode.problems.trie.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 */
@SuppressWarnings("Duplicates")
public class PrefixAndSuffixSearch {

	public static WordFilter wordFilter(String[] words) {
		return new PrefixAndSuffixSearch().createWordFilter(words);
	}

	private WordFilter createWordFilter(String[] words) {
		return new WordFilter(words);
	}

	/**
	 * Your WordFilter object will be instantiated and called as such:
	 * WordFilter obj = new WordFilter(words);
	 * int param_1 = obj.f(prefix,suffix);
	 */
	class WordFilter {

		private TrieNode root;

		public WordFilter(String[] words) {
			root = new TrieNode();
			for (int i = 0; i < words.length; i++) {
				insert(words[i], i);
			}
		}

		public int f(String prefix, String suffix) {
			TrieNode curr = root;
			for (int i = 0; i < prefix.length(); i++) {
				int idx = prefix.charAt(i) - 'a';
				if (curr.children[idx] == null) {
					return -1;
				}
				curr = curr.children[idx];
			}
			List<TrieNode> list = new ArrayList<>();
			searchAll(curr, list);
			int max = -1;
			for (TrieNode n : list) {
				if (n.word.endsWith(suffix)) {
					max = Math.max(max, n.weight);
				}
			}
			return max;
		}

		private void searchAll(TrieNode node, List<TrieNode> list) {
			if (node == null) {
				return;
			} else if (node.word != null) {
				list.add(node);
			}
			for (TrieNode child : node.children) {
				searchAll(child, list);
			}
		}

		private void insert(String word, int weight) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
			}
			curr.weight = weight;
			curr.word = word;
		}

		private class TrieNode {
			int weight = -1;
			String word;
			TrieNode[] children = new TrieNode[26];
		}

	}

}
