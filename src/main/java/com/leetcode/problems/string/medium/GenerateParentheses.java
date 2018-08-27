package com.leetcode.problems.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

	class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<>();
			backtracking(list, new char[n * 2], n, n);
			return list;
		}

		private void backtracking(List<String> list, char[] chars, int open, int close) {
			if (open == 0 && close == 0) {
				list.add(String.valueOf(chars));
				return;
			}

			int idx = chars.length - (open + close);

			if (open > 0) {
				chars[idx] = '(';
				backtracking(list, chars, open - 1, close);
			}
			if (open < close) {
				chars[idx] = ')';
				backtracking(list, chars, open, close - 1);
			}
		}
	}

}
