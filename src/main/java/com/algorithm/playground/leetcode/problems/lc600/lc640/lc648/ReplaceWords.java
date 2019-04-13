package com.algorithm.playground.leetcode.problems.lc600.lc640.lc648;

import java.util.List;

/**
 * https://leetcode.com/problems/replace-words/description/
 */
@SuppressWarnings("Duplicates")
public class ReplaceWords {

	class Solution {
		public String replaceWords(List<String> dict, String sentence) {
			TrieNode root = new TrieNode();
			for (String w : dict) {
				insert(root, w);
			}
			StringBuilder builder = new StringBuilder();
			for (String s : sentence.split(" ")) {
				builder.append(" ").append(search(root, s));
			}
			return builder.substring(1);
		}

		private String search(TrieNode root, String key) {
			TrieNode curr = root;
			for (int i = 0; i < key.length(); i++) {
				int idx = key.charAt(i) - 'a';
				if (curr.word != null) {
					return curr.word;
				} else if (curr.children[idx] == null) {
					return key;
				}
				curr = curr.children[idx];
			}
			return curr.word != null ? curr.word : key;
		}

		private void insert(TrieNode root, String word) {
			TrieNode curr = root;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (curr.children[idx] == null) {
					curr.children[idx] = new TrieNode();
				}
				curr = curr.children[idx];
			}
			curr.word = word;
		}

		private class TrieNode {
			String word;
			TrieNode[] children = new TrieNode[26];
		}
	}

}
