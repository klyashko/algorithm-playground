package com.algorithm.playground.leetcode.problems.lc800.lc890.lc890;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 */
public class FindAndReplacePattern {

	class Solution {
		public List<String> findAndReplacePattern(String[] words, String pattern) {
			int[] mask = new int[26];
			int next = 1;
			for (char ch : pattern.toCharArray()) {
				int idx = ch - 'a';
				if (mask[idx] == 0) {
					mask[idx] = next++;
				}
			}

			List<String> result = new ArrayList<>();

			for (String word : words) {
				if (test(word, pattern, mask)) {
					result.add(word);
				}
			}

			return result;
		}

		private boolean test(String word, String pattern, int[] mask) {
			if (word.length() != pattern.length()) {
				return false;
			}
			int[] wordMask = new int[26];
			int next = 1;
			for (int i = 0; i < word.length(); i++) {
				char wch = word.charAt(i);
				int idx = wch - 'a';
				if (wordMask[idx] == 0) {
					wordMask[idx] = next++;
				}
				if (wordMask[idx] != mask[pattern.charAt(i) - 'a']){
					return false;
				}
			}

			return true;
		}
	}

}
