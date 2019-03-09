package com.algorithm.playground.leetcode.problems.depthfirstsearch.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 */
public class RemoveInvalidParentheses {

	class Solution {
		public List<String> removeInvalidParentheses(String s) {
			int open = 0;
			int close = 0;

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '(') {
					open++;
				} else if (ch == ')') {
					if (open > 0) {
						open--;
					} else {
						close++;
					}
				}
			}

			Set<String> result = new HashSet<>();
			dfs("", s, result, open, close, 0, 0);

			return new ArrayList<>(result);
		}

		private void dfs(String current, String s, Set<String> result, int open, int close, int idx, int o) {
			if (o < 0 || open < 0 || close < 0) {
				return;
			}
			if (idx == s.length()) {
				if (o == 0 && open == 0 && close == 0) {
					result.add(current);
				}
				return;
			}
			char ch = s.charAt(idx);
			if (ch == '(') {
				dfs(current + "(", s, result, open, close, idx + 1, o + 1);
				dfs(current, s, result, open - 1, close, idx + 1, o);
			} else if (ch == ')') {
				dfs(current + ")", s, result, open, close, idx + 1, o - 1);
				dfs(current, s, result, open, close - 1, idx + 1, o);
			} else {
				dfs(current + ch, s, result, open, close, idx + 1, o);
			}
		}
	}

}
