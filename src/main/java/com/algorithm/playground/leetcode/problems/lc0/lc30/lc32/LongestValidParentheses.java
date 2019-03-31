package com.algorithm.playground.leetcode.problems.lc0.lc30.lc32;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class LongestValidParentheses {

	class Solution {
		public int longestValidParentheses(String s) {
			if (s.length() < 2) {
				return 0;
			}

			int max = 0, last = -1;

			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					stack.push(i);
				} else {
					if (stack.isEmpty()) {
						last = i;
					} else {
						stack.removeFirst();
						if (stack.isEmpty()) {
							max = Math.max(max, i - last);
						} else {
							max = Math.max(max, i - stack.peek());
						}
					}
				}
			}

			return max;
		}
	}

}
