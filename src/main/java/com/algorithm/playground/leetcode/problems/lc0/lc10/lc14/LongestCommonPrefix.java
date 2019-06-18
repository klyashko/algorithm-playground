package com.algorithm.playground.leetcode.problems.lc0.lc10.lc14;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

	class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0) {
				return "";
			}
			int len = strs[0].length(), k = 0;
			for (int i = 0; i < len; i++) {
				for (int j = 1; j < strs.length; j++) {
					if (strs[j].length() <= i || strs[j - 1].charAt(i) != strs[j].charAt(i)) {
						return strs[0].substring(0, k);
					}
				}
				k = i + 1;
			}
			return strs[0].substring(0, k);
		}
	}

}
