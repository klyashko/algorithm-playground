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
			backtracking(S.toCharArray(), 0, values);
			return values;
		}

		private void backtracking(char[] chars, int idx, List<String> values) {
			if (idx == chars.length) {
				values.add(String.valueOf(chars));
				return;
			}
			backtracking(chars, idx + 1, values);
			char ch = chars[idx];
			if (Character.isLowerCase(ch)) {
				chars[idx] = Character.toUpperCase(ch);
				backtracking(chars, idx + 1, values);
			} else if (Character.isUpperCase(ch)) {
				chars[idx] = Character.toLowerCase(ch);
				backtracking(chars, idx + 1, values);
			}
			chars[idx] = ch;
		}
	}

}
