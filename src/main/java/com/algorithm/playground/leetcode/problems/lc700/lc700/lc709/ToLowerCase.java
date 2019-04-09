package com.algorithm.playground.leetcode.problems.lc700.lc700.lc709;

/**
 * https://leetcode.com/problems/to-lower-case/description/
 */
public class ToLowerCase {

	class Solution {
		public String toLowerCase(String str) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch > 64 && ch < 91) {
					ch += 32;
				}
				builder.append(ch);
			}
			return builder.toString();
		}
	}

}
