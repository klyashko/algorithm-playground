package com.algorithm.playground.leetcode.problems.lc600.lc670.lc678;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class ValidParenthesisString {

	class Solution {

		private Map<String, Boolean> cache = new HashMap<>();

		public boolean checkValidString(String s) {
			return validate(s, 0, 0);
		}

		private boolean validate(String s, int idx, int count) {
			if ((idx == s.length() && count > 0) || count < 0) {
				return false;
			} else if (idx == s.length()) {
				return true;
			}
			String key = idx + "_" + count;

			if (!cache.containsKey(key)) {
				boolean ans;
				char ch = s.charAt(idx);
				if (ch == '(') {
					ans = validate(s, idx + 1, count + 1);
				} else if (ch == ')') {
					ans = validate(s, idx + 1, count - 1);
				} else {
					ans = validate(s, idx + 1, count + 1) || validate(s, idx + 1, count - 1) || validate(s, idx + 1, count);
				}
				cache.put(key, ans);
			}
			return cache.get(key);
		}
	}

}
