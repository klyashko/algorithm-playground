package com.algorithm.playground.leetcode.problems.lc400.lc470.lc472;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/concatenated-words/description/
 */
@SuppressWarnings("Duplicates")
public class ConcatenatedWords {

	class Solution {

		private TrieNode root = new TrieNode();

		public List<String> findAllConcatenatedWordsInADict(String[] words) {
			build(words);
			List<String> result = new ArrayList<>();
			for (String w : words) {
				if (test(w, 0, 0)) {
					result.add(w);
				}
			}
			return result;
		}

		private void build(String[] words) {
			for (String w : words) {
				if (w.isEmpty()) {
					continue;
				}
				TrieNode tmp = root;
				for (char ch : w.toCharArray()) {
					int idx = ch - 'a';
					if (tmp.children[idx] == null) {
						tmp.children[idx] = new TrieNode();
					}
					tmp = tmp.children[idx];
				}
				tmp.word = true;
			}
		}

		private boolean test(String word, int i, int count) {
			TrieNode tmp = root;
			for (; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (tmp.children[idx] == null) {
					return false;
				}
				tmp = tmp.children[idx];
				if (tmp.word && test(word, i + 1, count + 1)) {
					return true;
				}
			}
			return count >= 1 && tmp.word;
		}

		private class TrieNode {
			boolean word = false;
			TrieNode[] children = new TrieNode[26];
		}

	}

}
