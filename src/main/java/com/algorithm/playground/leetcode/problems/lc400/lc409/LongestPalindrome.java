package com.algorithm.playground.leetcode.problems.lc400.lc409;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

	class Solution {
		public int longestPalindrome(String s) {
			int[] lowercase = new int[26];
			int[] uppercase = new int[26];
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch <= 'Z') {
					uppercase[ch - 'A']++;
				} else {
					lowercase[ch - 'a']++;
				}
			}
			int count = 0, sum = 0;
			for (int i = 0; i < 26; i++) {
				count += ((lowercase[i] >> 1) + (uppercase[i] >> 1)) << 1;
				sum += (lowercase[i] & 1) + (uppercase[i] & 1);
			}
			return sum > 0 ? count + 1 : count;
		}
	}

}
