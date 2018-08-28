package com.leetcode.problems.string.hard;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {

	class Solution {

		private Map<String, Boolean> cache = new HashMap<>();

		public boolean isInterleave(String s1, String s2, String s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}

			String key = s1 + "_" + s2 + "_" + s3;
			return cache.computeIfAbsent(key, ignored -> {
				int s1Cursor = 0;
				int s2Cursor = 0;

				for (int i = 0; i < s3.length(); i++) {
					char ch = s3.charAt(i);
					if (s1Cursor < s1.length() && s2Cursor < s2.length()) {
						char ch1 = s1.charAt(s1Cursor);
						char ch2 = s2.charAt(s2Cursor);
						if (ch1 == ch && ch1 == ch2) {
							return isInterleave(s1.substring(s1Cursor), s2.substring(s2Cursor + 1), s3.substring(i + 1))
									|| isInterleave(s1.substring(s1Cursor + 1), s2.substring(s2Cursor), s3.substring(i + 1));
						} else if (ch1 == ch) {
							s1Cursor++;
						} else if (ch2 == ch) {
							s2Cursor++;
						} else {
							return false;
						}
					} else if (s1Cursor < s1.length()) {
						char ch1 = s1.charAt(s1Cursor);
						if (ch1 == ch) {
							s1Cursor++;
						} else {
							return false;
						}
					} else if (s2Cursor < s2.length()) {
						char ch2 = s2.charAt(s2Cursor);
						if (ch2 == ch) {
							s2Cursor++;
						} else {
							return false;
						}
					}
				}

				return true;
			});
		}
	}

}
