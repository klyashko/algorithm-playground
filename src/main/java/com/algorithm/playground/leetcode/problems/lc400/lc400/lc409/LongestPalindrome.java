package com.algorithm.playground.leetcode.problems.lc400.lc400.lc409;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	class Solution {
		public int longestPalindrome(String s) {
			int[] counts = new int[128];
			for (int i = 0; i < s.length(); i++) {
				counts[s.charAt(i)]++;
			}
			int count = 0;
			for (int i : counts) {
				if ((i & 1) == 0) {
					count += i;
				} else {
					count += i - 1;
				}
			}
			return count == s.length() ? count : count + 1;
		}
	}

}
