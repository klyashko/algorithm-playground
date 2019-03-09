package com.algorithm.playground.leetcode.problems.stack.easy;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

	class Solution {
		public boolean isValid(String s) {
			char[] stack = new char[s.length()];
			int top = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '(' || ch == '{' || ch == '[') {
					stack[top++] = ch;
				} else {
					if (top == 0 || stack[--top] != convert(ch)) {
						return false;
					}
				}
			}
			return top == 0;
		}

		private char convert(char ch) {
			switch (ch) {
				case ')':
					return '(';
				case '}':
					return '{';
				case ']':
					return '[';
				default:
					throw new IllegalArgumentException();
			}
		}
	}

}
