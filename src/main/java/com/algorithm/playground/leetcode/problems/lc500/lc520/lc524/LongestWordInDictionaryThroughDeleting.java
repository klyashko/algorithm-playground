package com.algorithm.playground.leetcode.problems.lc500.lc520.lc524;

import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class LongestWordInDictionaryThroughDeleting {

	class Solution {
		public String findLongestWord(String str, List<String> list) {
			String success = "";
			for (String s : list) {
				if (s.length() < success.length()) {
					continue;
				}
				if (test(str, s)) {
					if (success.length() < s.length()) {
						success = s;
					} else {
						success = success.compareTo(s) < 0 ? success : s;
					}
				}
			}

			return success;
		}

		private boolean test(String str, String sample) {
			int idx = 0;
			for (int i = 0; i < sample.length(); i++, idx++) {
				idx = str.indexOf(sample.charAt(i), idx);
				if (idx == -1) {
					return false;
				}
			}
			return true;
		}
	}

}
