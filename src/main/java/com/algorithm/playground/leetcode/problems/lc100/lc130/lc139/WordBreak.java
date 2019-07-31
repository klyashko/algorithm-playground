package com.algorithm.playground.leetcode.problems.lc100.lc130.lc139;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class WordBreak {

	class Solution {

		public boolean wordBreak(String s, List<String> wordDict) {
			TrieNode root = new TrieNode();
			for (String w : wordDict) {
				insert(root, w);
			}
			return wordBreak(root, s, 0, new boolean[s.length()]);
		}

		private boolean wordBreak(TrieNode root, String word, int idx, boolean[] cache) {
			if (idx == word.length()) {
				return true;
			} else if (cache[idx]) {
				return false;
			} else {
				for (String s : findAll(root, word, idx)) {
					if (wordBreak(root, word, idx + s.length(), cache)) {
						return true;
					}
				}
				cache[idx] = true;
				return false;
			}
		}

		private List<String> findAll(TrieNode root, String word, int idx) {
			List<String> result = new ArrayList<>();
			StringBuilder builder = new StringBuilder();
			for (; idx < word.length() && root != null; idx++) {
				if (root.isWord) {
					result.add(builder.toString());
				}
				char ch = word.charAt(idx);
				builder.append(ch);
				root = root.children[ch - 'a'];
			}
			if (root != null && root.isWord) {
				result.add(builder.toString());
			}
			return result;
		}

		private void insert(TrieNode root, String word) {
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				if (root.children[idx] == null) {
					root.children[idx] = new TrieNode();
				}
				root = root.children[idx];
			}
			root.isWord = true;
		}

		private class TrieNode {

			private TrieNode[] children = new TrieNode[26];
			private boolean isWord;

		}
	}

}
