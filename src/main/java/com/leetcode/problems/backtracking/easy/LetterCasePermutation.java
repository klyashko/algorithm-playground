package com.leetcode.problems.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation {

	class Solution {
		public List<String> letterCasePermutation(String S) {
			List<String> values = new ArrayList<>();
			backtracking(new StringBuilder(S.toLowerCase()), 0, values);
			return values;
		}

		private void backtracking(StringBuilder builder, int idx, List<String> values) {
			if (idx == builder.length()) {
				values.add(builder.toString());
				return;
			}
			backtracking(builder, idx + 1, values);
			char ch = builder.charAt(idx);
			if (Character.isLowerCase(ch)) {
				builder.setCharAt(idx, Character.toUpperCase(ch));
				backtracking(builder, idx + 1, values);
				builder.setCharAt(idx, ch);
			}
		}
	}

}
