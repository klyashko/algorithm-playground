package com.leetcode.problems.dynamic.programming.medium;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

	class Solution {
		public int countSubstrings(String s) {
			if (s.isEmpty()) {
				return 0;
			}
			int count = 1;
			for (int i = 1; i < s.length(); i++) {
				int start = -1, end = -1;
				if (s.charAt(i - 1) == s.charAt(i)) {
					start = i - 1;
					end = i;
					while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
						start--;
						end++;
					}
					count += (end - start - 1) / 2;
				}
				if (i > 1 && s.charAt(i - 2) == s.charAt(i)) {
					start = i - 2;
					end = i;

					while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
						start--;
						end++;
					}
					count += (end - start - 1) / 2;
				}
				count++;
			}
			return count;
		}

		private int countPalindromecLength(int start, int end, String s) {
			while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			}
			return (end - start - 1);
		}

	}

}
