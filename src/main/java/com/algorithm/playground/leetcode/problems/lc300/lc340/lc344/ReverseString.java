package com.algorithm.playground.leetcode.problems.lc300.lc340.lc344;

/**
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {

	class Solution {
		public String reverseString(String s) {
			int left = 0;
			int right = s.length() - 1;
			StringBuilder builder = new StringBuilder(s);
			while (left < right) {
				builder.setCharAt(left, s.charAt(right));
				builder.setCharAt(right, s.charAt(left));
				left++;
				right--;
			}
			return builder.toString();
		}
	}

}
