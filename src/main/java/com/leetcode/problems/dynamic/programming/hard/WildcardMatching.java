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
			if (cache.containsKey(key)) {
				return cache.get(key);
			}
			if ("*".equals(p)) {
				return true;
			} else if (s.length() == 1 && "?".equals(p)) {
				return true;
			}
			boolean result = false;
			int cursor = 0;
			int i = 0;
			for (; i < p.length(); i++) {
				if (cursor >= s.length()) {
					while (i < p.length() && p.charAt(i) == '*') {
						i++;
					}
					result = i == p.length();
					break;
				} else if ('?' == p.charAt(i)) {
					cursor++;
					continue;
				} else if ('*' == p.charAt(i)) {
					int offset = 0;
					while (i < p.length() && ('*' == p.charAt(i) || '?' == p.charAt(i))) {
						if ('?' == p.charAt(i)) {
							offset++;
						}
						i++;
					}
					if (i == p.length()) {
						result = offset == 0 || s.length() - cursor >= offset;
						break;
					}
					if (offset > s.length() - cursor) {
						break;
					}
					cursor += offset;
					while (cursor < s.length() && !result) {
						if (s.charAt(cursor) == p.charAt(i)) {
							result = isMatch(s.substring(cursor), p.substring(i));
						}
						cursor++;
					}
					break;
				} else if (s.charAt(cursor) != p.charAt(i)) {
					break;
				}
				cursor++;
			}
			result = result || (cursor == s.length() && i == p.length());
			cache.put(key, result);
			return result;
		}
	}

}
