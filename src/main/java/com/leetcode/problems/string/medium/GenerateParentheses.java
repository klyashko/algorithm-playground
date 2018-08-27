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

			StringBuilder builder = new StringBuilder(n * 2);
			builder.append(new char[n * 2]);

			backtracking(list, builder, n, n);
			return list;
		}

		private void backtracking(List<String> list, StringBuilder current, int open, int close) {
			if (open == 0 && close == 0) {
				list.add(current.toString());
				return;
			}

			int idx = current.length() - (open + close);

			if (open > 0) {
				current.setCharAt(idx, '(');
				backtracking(list, current, open - 1, close);
			}
			if (close > 0 && open < close) {
				current.setCharAt(idx, ')');
				backtracking(list, current, open, close - 1);
			}
		}
	}

}
