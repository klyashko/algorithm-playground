package com.algorithm.playground.leetcode.problems.lc600.lc647;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

	class Solution {
		public int countSubstrings(String s) {
			if (s.isEmpty()) {
				return 0;
			}
			int count = s.length();
			for (int i = 0; i < s.length(); i++) {
				count += countPalindromicLength(i, i, s) / 2;
				count += countPalindromicLength(i - 1, i, s) / 2;
			}
			return count;
		}

		private int countPalindromicLength(int start, int end, String s) {
			while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			}
			return (end - start - 1);
		}

	}

}
