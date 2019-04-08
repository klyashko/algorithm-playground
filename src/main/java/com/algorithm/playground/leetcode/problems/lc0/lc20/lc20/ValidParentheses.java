package com.algorithm.playground.leetcode.problems.lc0.lc20.lc20;

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
					char expected = (char) (ch - (ch == ')' ? 1 : 2));
					if (top == 0 || stack[--top] != expected) {
						return false;
					}
				}
			}
			return top == 0;
		}

	}

}
