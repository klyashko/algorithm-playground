package com.algorithm.playground.leetcode.problems.lc800.lc840.lc844;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/backspace-string-compare/description/
 */
public class BackspaceStringCompare {

	class Solution {
		public boolean backspaceCompare(String S, String T) {
			return Arrays.equals(cleanUp(S), cleanUp(T));
		}

		private char[] cleanUp(String s) {
			char[] chars = new char[s.length()];
			int idx = 0;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '#') {
					idx = Math.max(0, idx - 1);
				} else {
					chars[idx++] = s.charAt(i);
				}
			}
			return Arrays.copyOf(chars, idx);
		}
	}


}
