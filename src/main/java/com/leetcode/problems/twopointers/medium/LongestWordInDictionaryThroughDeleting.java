package com.leetcode.problems.twopointers.medium;

import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class LongestWordInDictionaryThroughDeleting {

	class Solution {
		public String findLongestWord(String str, List<String> list) {
			list.sort(Comparator.comparingInt(String::length).reversed());
			String success = "";
			for (String s : list) {
				if (s.length() < success.length()) {
					break;
				}
				if (test(str, s)) {
					if (success.isEmpty()) {
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
