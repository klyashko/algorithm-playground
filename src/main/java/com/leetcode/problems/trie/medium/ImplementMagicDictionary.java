package com.leetcode.problems.trie.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 */
public class ImplementMagicDictionary {

	/**
	 * Your MagicDictionary object will be instantiated and called as such:
	 * MagicDictionary obj = new MagicDictionary();
	 * obj.buildDict(dict);
	 * boolean param_2 = obj.search(word);
	 */
	class MagicDictionary {

		private Set<String> set;

		/**
		 * Initialize your data structure here.
		 */
		public MagicDictionary() {
			set = new HashSet<>();
		}

		/**
		 * Build a dictionary through a list of words
		 */
		public void buildDict(String[] dict) {
			set.addAll(Arrays.asList(dict));
		}

		/**
		 * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
		 */
		public boolean search(String word) {
			StringBuilder builder = new StringBuilder(word);
			for (int i = 0; i < builder.length(); i++) {
				char curr = builder.charAt(i);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (ch != curr) {
						builder.setCharAt(i, ch);
						if (set.contains(builder.toString())) {
							return true;
						}
					}
				}
				builder.setCharAt(i, curr);
			}
			return false;
		}
	}

}
