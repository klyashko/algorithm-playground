package com.leetcode.problems.dynamic.programming.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/wildcard-matching/description/
 */
public class WildcardMatching {

	class Solution {

		private Map<String, Boolean> cache = new HashMap<>();

		public boolean isMatch(String s, String p) {
			String key = s + "_" + p;
			return cache.computeIfAbsent(key, ignored -> {
				if ("*".equals(p)) {
					return true;
				} else if (s.length() == 1 && "?".equals(p)) {
					return true;
				}
				int cursor = 0;
				int i = 0;
				for (; i < p.length(); i++) {
					if (cursor >= s.length()) {
						return containsOnlyStars(p, i);
					} else if ('?' == p.charAt(i)) {
						cursor++;
						continue;
					} else if ('*' == p.charAt(i)) {
						return processStar(p, i, s, cursor);
					} else if (s.charAt(cursor) != p.charAt(i)) {
						return false;
					}
					cursor++;
				}
				return cursor == s.length() && i == p.length();
			});
		}

		private boolean containsOnlyStars(String pattern, int positionInPattern) {
			while (positionInPattern < pattern.length() && pattern.charAt(positionInPattern) == '*') {
				positionInPattern++;
			}
			return positionInPattern == pattern.length();
		}

		private boolean processStar(String pattern, int positionInPattern, String str, int positionInString) {
			int offset = 0;
			while (positionInPattern < pattern.length() && ('*' == pattern.charAt(positionInPattern) || '?' == pattern
				.charAt(positionInPattern))) {
				if ('?' == pattern.charAt(positionInPattern)) {
					offset++;
				}
				positionInPattern++;
			}
			if (positionInPattern == pattern.length()) {
				return offset == 0 || str.length() - positionInString >= offset;
			}
			if (offset > str.length() - positionInString) {
				return false;
			}
			positionInString += offset;
			while (positionInString < str.length()) {
				if (str.charAt(positionInString) == pattern.charAt(positionInPattern)) {
					if (isMatch(str.substring(positionInString), pattern.substring(positionInPattern))) {
						return true;
					}
				}
				positionInString++;
			}
			return false;
		}

	}

}
