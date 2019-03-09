package com.algorithm.playground.leetcode.problems.sort.easy;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class ValidAnagram {

	class Solution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length()) {
				return false;
			}
			int[] chars = new int[26];
			for (int i = 0; i < s.length(); i++) {
				chars[s.charAt(i) - 'a']++;
				chars[t.charAt(i) - 'a']--;
			}

			for (int ch : chars) {
				if (ch != 0) {
					return false;
				}
			}
			return true;
		}
	}

}
