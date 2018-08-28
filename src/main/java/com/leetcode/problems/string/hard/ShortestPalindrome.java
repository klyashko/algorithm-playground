package com.leetcode.problems.string.hard;

public class ShortestPalindrome {

	class Solution {

		public String shortestPalindrome(String s) {
			if (s.length() < 2) {
				return s;
			}
			int idx = s.length() / 2;
			String absent = "";

			for (; idx >= 0; idx--) {
				if (test(s, idx, idx)) {
					absent = s.substring(idx * 2 + 1);
					break;
					//				} else if (test(s, idx - 1, idx)) {
				} else if (idx > 0 && test(s, idx - 1, idx)) {
					//					absent = s.substring(idx * 2 + 2);
					absent = s.substring(idx * 2);
					break;
				}
			}

			StringBuilder builder = new StringBuilder(absent.length());

			for (int i = absent.length() - 1; i >= 0; i--) {
				builder.append(absent.charAt(i));
			}

			return builder.append(s).toString();
		}

		private boolean test(String str, int left, int right) {
			while (left >= 0 && right < str.length()) {
				if (str.charAt(left) != str.charAt(right)) {
					break;
				}
				left--;
				right++;
			}
			return left == -1;
		}

	}
}
