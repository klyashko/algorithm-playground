package com.leetcode.problems.twopointers.medium;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class LongestWordInDictionaryThroughDeleting {

	class Solution {
		public String findLongestWord(String str, List<String> list) {
			list.sort(Comparator.comparingInt(String::length).reversed());
			String lastSuccess = "";
			TreeSet<String> success = new TreeSet<>();

			for (String s : list) {
				if (s.length() < lastSuccess.length()) {
					break;
				}
				if (test(str, s)) {
					lastSuccess = s;
					success.add(s);
				}
			}

			return success.isEmpty() ? "" : success.first();
		}

		private boolean test(String str, String sample) {
			int idx = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == sample.charAt(idx)) {
					idx++;
					if (idx == sample.length()) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
