package com.leetcode.problems.string.medium;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class ValidParenthesisString {

	class Solution {
		public boolean checkValidString(String s) {
			return validate(s, 0, 0);
		}

		private boolean validate(String s, int idx, int count) {
			if ((idx == s.length() && count > 0) || count < 0) {
				return false;
			} else if (idx == s.length()) {
				return true;
			}
			char ch = s.charAt(idx);
			if (ch == '(') {
				return validate(s, idx + 1, count + 1);
			} else if (ch == ')') {
				return validate(s, idx + 1, count - 1);
			} else {
				return validate(s, idx + 1, count + 1) || validate(s, idx + 1, count - 1) || validate(s, idx + 1, count);
			}
		}
	}

}
